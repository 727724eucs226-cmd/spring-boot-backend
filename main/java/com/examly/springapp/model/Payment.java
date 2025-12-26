package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {
    @Id
    private Long id;
    private Double amountPaid;

    public Payment() {}
    public Payment(Long id, Double amountPaid) { this.id = id; this.amountPaid = amountPaid; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getAmountPaid() { return amountPaid; }
    public void setAmountPaid(Double amountPaid) { this.amountPaid = amountPaid; }
}
