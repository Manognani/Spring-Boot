package com.tejait.batch15.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.dto.CustomerProductsRequest;
import com.tejait.batch15.model.Customer;
import com.tejait.batch15.service.CustomerDataService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	CustomerDataService service;
	
	@PostMapping("save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		 Customer createdCustomer=service.saveCustomer(customer);
	 return new ResponseEntity<>(createdCustomer,HttpStatus.CREATED);	    
	}
	@PostMapping("mapProductsTocustomers")
	public ResponseEntity<Customer> mapProductsTocustomers(@RequestBody CustomerProductsRequest request){
		Customer customer=service.mapProductsTocustomers(request);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	

}
