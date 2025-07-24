package com.shirtms.billing.controller;

import com.shirtms.billing.entity.Bill;
import com.shirtms.billing.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillingController {

    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        return billingService.generateBill(bill);
    }

    @GetMapping
    public List<Bill> getAllBills() {
        return billingService.getAllBills();
    }
}
