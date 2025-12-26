package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.LoanType;

@Repository
public interface LoanTypeRepo extends JpaRepository<LoanType, Long> {}
