package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.repository.CompanyDetailsRepository;
import com.tejait.batch15.service.CompanyDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CompanyDetailsServiceimpl implements CompanyDetailsService {

    CompanyDetailsRepository repository;

    @Override
    public CompanyDetails saveDetails(CompanyDetails cdetails) {
        return repository.save(cdetails);
    }

    @Override
    public CompanyDetails getCompanyDetails(Integer appId) {
        return repository.findByAppId(appId);
    }
}
