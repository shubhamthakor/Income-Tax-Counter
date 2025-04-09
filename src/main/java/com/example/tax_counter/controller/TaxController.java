package com.example.tax_counter.controller;

import com.example.tax_counter.model.TaxRequest;
import com.example.tax_counter.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tax")
@CrossOrigin(origins = "*")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @PostMapping("/calculate")
    public double calculateTax(@RequestBody TaxRequest request) {
        return taxService.calculateTax(request.getIncome());
    }
}
