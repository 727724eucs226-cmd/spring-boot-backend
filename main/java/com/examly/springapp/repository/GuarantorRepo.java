package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.Guarantor;

@Repository
public interface GuarantorRepo extends JpaRepository<Guarantor, Long> {}
