package com.tejait.batch15.repository;

import com.tejait.batch15.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansRepository extends JpaRepository<Loans,Integer> {

    Loans findByAppId(int appId);
}
