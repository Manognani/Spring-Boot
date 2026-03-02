package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.repository.CompanyAddressRepository;
import com.tejait.batch15.service.CompanyAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CompanyAddressServiceimpl implements CompanyAddressService {

    CompanyAddressRepository repository;

    @Override
    public CompanyAddress saveAddress(CompanyAddress cadds) {
        return repository.save(cadds);
    }
    @Override
    public CompanyAddress getAdress(Integer appId) {
        return repository.findByAppId(appId);
    }
}
