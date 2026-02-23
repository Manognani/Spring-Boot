package com.tejait.batch15.serviceimpl;

import org.springframework.stereotype.Service;

import com.tejait.batch15.service.CustomerService;


@Service("retail")
public class RetailCustomerServiceimpl implements CustomerService {

	@Override
	public String getCustomerType() {
	
		return "Retail Customer";
	}

}
