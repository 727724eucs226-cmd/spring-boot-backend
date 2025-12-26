package com.examly.springapp.service;

import com.examly.springapp.model.LoanType;
import com.examly.springapp.repository.LoanTypeRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class LoanTypeService {

    private final LoanTypeRepo loanTypeRepo;

    public LoanTypeService(LoanTypeRepo loanTypeRepo) {
        this.loanTypeRepo = loanTypeRepo;
    }

    public LoanType addLoanType(LoanType loanType) {
        return loanTypeRepo.save(loanType);
    }

    public List<LoanType> getAllLoanTypes() {
        return loanTypeRepo.findAll();
    }

    public LoanType updateLoanType(Long id, LoanType updatedLoanType) {
        return loanTypeRepo.findById(id).map(existing -> {
            existing.setTypeName(updatedLoanType.getTypeName());
            existing.setInterestRate(updatedLoanType.getInterestRate());
            existing.setTenureMonths(updatedLoanType.getTenureMonths());
            return loanTypeRepo.save(existing);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "LoanType not found"));
    }
}
