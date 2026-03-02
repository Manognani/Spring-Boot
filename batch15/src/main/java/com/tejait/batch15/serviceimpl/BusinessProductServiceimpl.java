package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.repository.BusinessProductRepository;
import com.tejait.batch15.service.BusinessProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class BusinessProductServiceimpl implements BusinessProductService {

    BusinessProductRepository repository;
    @Override
    public BusinessProduct saveProduct(BusinessProduct bprod) {
        return repository.save(bprod);
    }
    @Override
    public List<BusinessProduct> getAllProducts(Integer appId) {
        return Collections.singletonList(repository.findByAppId(appId));
    }

}

