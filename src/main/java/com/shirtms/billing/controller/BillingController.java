package com.shirtms.billing.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shirtms.billing.entity.Bill;
import com.shirtms.billing.service.BillingService;

@RestController
@RequestMapping("/api/bill")
public class BillingController {

    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    // Create a new bill
    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        return billingService.generateBill(bill);
    }

    // Get all bills
    @GetMapping
    public List<Bill> getAllBills() {
        return billingService.getAllBills();
    }

    // Get bill by ID
    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id) {
        return billingService.getBillById(id).orElse(null);
    }

    // Update an existing bill
    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable Long id, @RequestBody Bill updatedBill) {
        return billingService.updateBill(id, updatedBill);
    }

    // Delete a bill by ID
    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id) {
        billingService.deleteBill(id);
    }

    // Get bills by customer name
    @GetMapping("/by-name")
    public List<Bill> getBillsByCustomerName(@RequestParam String name) {
        return billingService.getBillsByCustomerName(name);
    }

    // Get bills by date
    @GetMapping("/by-date")
    public List<Bill> getBillsByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return billingService.getBillsByDate(date);
    }
}
