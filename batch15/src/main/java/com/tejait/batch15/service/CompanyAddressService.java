package com.tejait.batch15.service;

import com.tejait.batch15.model.CompanyAddress;

public interface CompanyAddressService {
    CompanyAddress saveAddress(CompanyAddress cadds);

    CompanyAddress getAdress(Integer appId);
}
