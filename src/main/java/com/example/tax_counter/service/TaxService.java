package com.example.tax_counter.service;

import org.springframework.stereotype.Service;

@Service
public class TaxService {

    public double calculateTax(double income) {
        double tax = 0;

        if (income <= 400000) {
            tax = 0;
            
        } else if (income <= 800000) {
            tax = (income - 400000) * 0.05;
            
        } else if (income <= 1200000) {
            tax = (800000 - 400000) * 0.05
                + (income - 800000) * 0.10;
                
        } else if (income <= 1600000) {
            tax = (800000 - 400000) * 0.05
                + (1200000 - 800000) * 0.10
                + (income - 1200000) * 0.15;
                
        } else if (income <= 2000000) {
            tax = (800000 - 400000) * 0.05
                + (1200000 - 800000) * 0.10
                + (1600000 - 1200000) * 0.15
                + (income - 1600000) * 0.20;
                
        } else if (income <= 2400000) {
            tax = (800000 - 400000) * 0.05
                + (1200000 - 800000) * 0.10
                + (1600000 - 1200000) * 0.15
                + (2000000 - 1600000) * 0.20
                + (income - 2000000) * 0.25;
                
        } else {
            tax = (800000 - 400000) * 0.05
                + (1200000 - 800000) * 0.10
                + (1600000 - 1200000) * 0.15
                + (2000000 - 1600000) * 0.20
                + (2400000 - 2000000) * 0.25
                + (income - 2400000) * 0.30;
                
        }
        return tax;
    }
}
