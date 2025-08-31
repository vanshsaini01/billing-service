package com.shirtms.billing.service;

import com.shirtms.billing.entity.Bill;
import com.shirtms.billing.repository.BillRepository;
import com.shirtms.billing.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService {

    private final BillRepository billRepository;

    @Autowired
    public BillingServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Bill generateBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Optional<Bill> getBillById(Long id) {
        return billRepository.findById(id);
    }

    @Override
    public Bill updateBill(Long id, Bill updatedBill) {
        return billRepository.findById(id).map(existingBill -> {
            existingBill.setCustomerName(updatedBill.getCustomerName());
            existingBill.setAmount(updatedBill.getAmount());
            existingBill.setDate(updatedBill.getDate());
            return billRepository.save(existingBill);
        }).orElseThrow(() -> new RuntimeException("Bill not found with id: " + id));
    }

    @Override
    public void deleteBill(Long id) {
        if (billRepository.existsById(id)) {
            billRepository.deleteById(id);
        } else {
            throw new RuntimeException("Bill not found with id: " + id);
        }
    }

    @Override
    public List<Bill> getBillsByCustomerName(String customerName) {
        return billRepository.findByCustomerName(customerName);
    }

    @Override
    public List<Bill> getBillsByDate(LocalDate date) {
        return billRepository.findByDate(date);
    }
}
