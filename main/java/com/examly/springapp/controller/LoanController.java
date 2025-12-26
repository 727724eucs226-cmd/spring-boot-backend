package com.examly.springapp.controller;

import com.examly.springapp.model.Loan;
import com.examly.springapp.service.LoanService;
import com.examly.springapp.repository.LoanRepo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanRepo loanRepo;
    private final LoanService loanService;

    public LoanController(LoanRepo loanRepo, LoanService loanService) {
        this.loanRepo = loanRepo;
        this.loanService = loanService;
    }

    
    @PostMapping
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) {
        Loan saved = loanService.addLoan(loan);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }
    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id);
    }

    @PutMapping("/{id}")
    public Loan updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
        return loanService.updateLoan(id, loan);
    }

    @GetMapping("/page/{page}/{size}")
    public Map<String, Object> getLoansWithPagination(@PathVariable int page, @PathVariable int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Loan> loanPage = loanRepo.findAll(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("content", loanPage.getContent());
        response.put("totalElements", loanPage.getTotalElements());
        response.put("totalPages", loanPage.getTotalPages());
        response.put("sort", loanPage.getSort());

        return response;
    } 
 @GetMapping("/status/{status}")
public ResponseEntity<?> getLoansByStatus(@PathVariable String status) {
    List<Loan> loans = loanService.getLoansByStatus(status);

    if (loans.isEmpty()) {
     
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("No loans found with status: " + status);
    }

    return ResponseEntity.ok(loans);
}





}
