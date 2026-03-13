package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.repository.BusinessProductRepository;
import com.tejait.batch15.service.BusinessProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BusinessProductServiceimpl implements BusinessProductService {

    private BusinessProductRepository repository;

    @Override
    public BusinessProduct saveProduct(BusinessProduct bprod) {
        return repository.save(bprod);
    }

    @Override
    public BusinessProduct getAllProducts(Integer appId) {
        return repository.findByAppId(appId);
    }
}