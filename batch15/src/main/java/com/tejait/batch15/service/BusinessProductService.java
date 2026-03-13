package com.tejait.batch15.service;

import com.tejait.batch15.model.BusinessProduct;

import java.util.List;

public interface BusinessProductService {
    BusinessProduct saveProduct(BusinessProduct bprod);

    BusinessProduct getAllProducts(Integer appId);
}
