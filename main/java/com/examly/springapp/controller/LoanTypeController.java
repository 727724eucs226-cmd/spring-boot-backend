package com.examly.springapp.controller;

import com.examly.springapp.model.LoanType;
import com.examly.springapp.service.LoanTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loantypes")
public class LoanTypeController {

    private final LoanTypeService loanTypeService;

    public LoanTypeController(LoanTypeService loanTypeService) {
        this.loanTypeService = loanTypeService;
    }

    @PostMapping
    public ResponseEntity<LoanType> addLoanType(@RequestBody LoanType loanType) {
        LoanType saved = loanTypeService.addLoanType(loanType);
        return new ResponseEntity<>(saved, HttpStatus.CREATED); 
    }

    @GetMapping
    public List<LoanType> getAllLoanTypes() {
        return loanTypeService.getAllLoanTypes();
    }

    @PutMapping("/{id}")
    public LoanType updateLoanType(@PathVariable Long id, @RequestBody LoanType updatedLoanType) {
        return loanTypeService.updateLoanType(id, updatedLoanType);
    }
}
