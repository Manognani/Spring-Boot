package com.tejait.batch15.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.model.Payment;
import com.tejait.batch15.service.PaymentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("payment")
public class PaymentController {
	
	PaymentService service;
	
	private static final Logger logger=LogManager.getLogger(PaymentController.class);
	
	@PostMapping("makepayments")
	public ResponseEntity<Payment> makePayment(@RequestBody Payment payment){
		
		logger.debug("Enterd Into Payment Controller");
		//System.out.println("Enterd Into Payment Controller");
		
		logger.info("Payment Data :{}" ,payment);
		//System.out.println("Payment Data From User:: "+payment);
		
		Payment savedPayment=service.savePayment(payment);
		logger.info("Saved payment Data :{}",savedPayment);
		
		return new ResponseEntity<>(savedPayment,HttpStatus.OK);
		                
	}
	@GetMapping("byPamentId/{paymentId}")
	public ResponseEntity<Payment> getPaymentBypaymentId(@PathVariable Integer paymentId){
		
		System.out.println("Enterd Into getPaymentBypaymentId");
		System.out.println("PaymentId:: "+paymentId);
	     Payment payment=service.getByPamentId(paymentId);
		return new ResponseEntity<>(payment,HttpStatus.OK);
		
		
	}
	@GetMapping("refundByPaymentById/{paymentId}")
	public ResponseEntity<Payment> getRefundBypaymentId(@PathVariable Integer paymentId){
		
		System.out.println("Enterd Into getrefundBypaymentId");
		System.out.println("paymentId:: "+paymentId);
	   Payment payment=service.getRefundByPaymentId(paymentId);
		return new ResponseEntity<>(payment,HttpStatus.OK);
		
		
		
		
		
		
		
	}

}
