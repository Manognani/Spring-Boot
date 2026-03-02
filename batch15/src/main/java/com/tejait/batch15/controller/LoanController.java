package com.tejait.batch15.controller;

import com.tejait.batch15.model.Loans;
import com.tejait.batch15.service.LoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class LoanController {

    LoansService service;

    @PostMapping("applyLoan")
    public ResponseEntity<Loans> saveLoan(@RequestBody Loans loans){
        Loans savedLoan =service.saveLoan(loans);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);

    }

    @GetMapping("loanTaskboard")
    public ResponseEntity<List<Loans>> getAllloans(){
        List<Loans> getAll =service.getLoans();
        return new ResponseEntity<>(getAll, HttpStatus.OK);

    }
}

