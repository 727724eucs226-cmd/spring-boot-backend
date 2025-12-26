package com.examly.springapp.repository;

import com.examly.springapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
   
    Customer findByEmail(String email);

    List<Customer> findByCreditScoreGreaterThanEqual(double creditScore);
}
