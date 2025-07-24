package com.shirtms.billing.service;

import com.shirtms.billing.entity.Bill;

import java.util.List;

public interface BillingService {
    Bill generateBill(Bill bill);
    List<Bill> getAllBills();
}
