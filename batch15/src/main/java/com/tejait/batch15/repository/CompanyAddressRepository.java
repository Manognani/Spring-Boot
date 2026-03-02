package com.tejait.batch15.repository;

import com.tejait.batch15.model.CompanyAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompanyAddressRepository extends JpaRepository<CompanyAddress,Integer> {
     CompanyAddress findByAppId(Integer appId);
}
