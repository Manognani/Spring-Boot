package com.tejait.batch15.service;

import com.tejait.batch15.model.CompanyDetails;

public interface CompanyDetailsService {
    CompanyDetails saveDetails(CompanyDetails cdetails);

    CompanyDetails getCompanyDetails(Integer appId);
}
