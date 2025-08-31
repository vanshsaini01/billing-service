package com.shirtms.billing.repository;

import com.shirtms.billing.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    // Custom query methods
    List<Bill> findByCustomerName(String customerName);

    List<Bill> findByDate(LocalDate date);
}
