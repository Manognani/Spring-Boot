package com.tejait.batch15.service;

import com.tejait.batch15.dto.CustomerProductsRequest;
import com.tejait.batch15.model.Customer;

public interface CustomerDataService {

	Customer saveCustomer(Customer customer);

	Customer mapProductsTocustomers(CustomerProductsRequest request);

}
