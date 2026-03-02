package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.Loans;
import com.tejait.batch15.repository.LoansRepository;
import com.tejait.batch15.service.LoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LoansServiceimpl implements LoansService {

    LoansRepository repository;
    @Override
    public Loans saveLoan(Loans loans) {
        String fname=loans.getFname();
        String lname= loans.getLname();
        loans.setCustomerName(fname.concat(" "+lname));
        return repository.save(loans);
    }

    @Override
    public List<Loans> getLoans() {
        return repository.findAll();
    }
}
