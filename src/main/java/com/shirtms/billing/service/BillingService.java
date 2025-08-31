// package com.shirtms.billing.service;

// import com.shirtms.billing.entity.Bill;

// import java.time.LocalDate;
// import java.util.List;

// public interface BillingService {

//     Bill generateBill(Bill bill);

//     Bill updateBill(Long id, Bill bill);

//     void deleteBill(Long id);

//     Bill getBillById(Long id);

//     List<Bill> getBillsByCustomerName(String customerName);

//     List<Bill> getBillsByDate(LocalDate billDate);

//     List<Bill> getAllBills();
// }

package com.shirtms.billing.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.shirtms.billing.entity.Bill;

public interface BillingService {

    // Create a new bill
    Bill generateBill(Bill bill);

    // Get all bills
    List<Bill> getAllBills();

    // Get bill by ID
    Optional<Bill> getBillById(Long id);

    // Update bill
    Bill updateBill(Long id, Bill updatedBill);

    // Delete bill
    void deleteBill(Long id);

    // Get bills by customer name
    List<Bill> getBillsByCustomerName(String customerName);

    // Get bills by date
    List<Bill> getBillsByDate(LocalDate date);
}
