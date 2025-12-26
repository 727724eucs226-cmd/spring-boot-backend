package com.examly.springapp.service;

import com.examly.springapp.model.Loan;
import com.examly.springapp.repository.LoanRepo;


import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepo loanRepo;

    public LoanService(LoanRepo loanRepo) {
        this.loanRepo = loanRepo;
    }

    public Loan addLoan(Loan loan) {
        return loanRepo.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepo.findById(id).orElse(null);
    }

    public Loan updateLoan(Long id, Loan loan) {
        loan.setLoanId(id);
        return loanRepo.save(loan);
    }

   public List<Loan> getLoansByStatus(String status) {
    List<Loan> result = new ArrayList<>();
    for (Loan loan : loanRepo.findAll()) {
        if (loan.getStatus() != null && loan.getStatus().equalsIgnoreCase(status)) {
            result.add(loan);
        }
    }
 
    return result;
}


}
