package com.tejait.batch15.service;

import com.tejait.batch15.model.Loans;

import java.util.List;

public interface LoansService {
    Loans saveLoan(Loans loans);

    List<Loans> getLoans();
}
