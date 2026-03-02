package com.tejait.batch15.repository;

import com.tejait.batch15.model.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails,Integer> {

    CompanyDetails findByAppId(Integer appId);
}
