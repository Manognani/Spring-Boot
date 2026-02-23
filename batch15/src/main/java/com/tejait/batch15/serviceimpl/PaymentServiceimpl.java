package com.tejait.batch15.serviceimpl;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tejait.batch15.model.Payment;
import com.tejait.batch15.repository.PaymentRepository;
import com.tejait.batch15.service.PaymentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class PaymentServiceimpl implements PaymentService {
	
	PaymentRepository repository;
	
	private static final Logger logger=LogManager.getLogger(PaymentServiceimpl.class);
	
	@Override
	public Payment savePayment(Payment payment) {
		logger.debug("Enterd Into Payment Service");
		logger.info("payment Data :{}",payment);
		//System.out.println("Enterd Into Payment Service");
		
		if(payment.getAmount()<1) {
			logger.info("Transaction Amount:{}",payment.getAmount());
			//System.out.println("Transaction Amount:: "+payment.getAmount());
			
			payment.setTransactionId(UUID.randomUUID().toString());
			payment.setPaymentStatus("Failed");
			logger.warn("Payment Staus:{} , Transaction Id:{}",payment.getPaymentStatus(),payment.getTransactionId());
			//System.out.println("Payment Staus:: "+payment.getPaymentStatus());
			logger.error("Invalid Amount : {}", payment.getAmount());
	        throw new RuntimeException(" Invalid Amount");
		}
		
		if(payment.getAmount()>100000) {
			
			logger.warn("Faurd Alert : {}",payment.getPayerName());
			//System.out.println("Fruad Alert:: "+payment.getPayerName());
			
			logger.warn("High Amount Transaction : {}",payment.getAmount());
			//System.out.println("Alert higher amount transcation:: "+payment.getAmount());
			
		}
		try {
			payment.setTransactionId(UUID.randomUUID().toString());
			payment.setPaymentStatus("Success");
			
		     return repository.save(payment);
		}catch (Exception e) {
			logger.error("Error While making payment");
			//System.out.println("Error While making payment");
			throw e;
		}
		
	}

	@Override
	public Payment getByPamentId(Integer paymentId) {
	
	return repository.findById(paymentId).orElseThrow(()-> new IllegalArgumentException("Id Not Found"));
	}

	@Override
	public Payment getRefundByPaymentId(Integer paymentId) {
		Payment payment=repository.findById(paymentId)
				.orElseThrow(()->{
					
					logger.error("payment ID Not Found : {} ",paymentId);
					//System.out.println("payment ID Not Found:: "+paymentId);
					
					return new IllegalArgumentException("payment Not Found");
				});
		
	if(!payment.getPaymentStatus().equalsIgnoreCase("Success")) {
		logger.error("payment status is not success : {}",payment.getPaymentStatus());
		logger.error("payment Not allowed for refund",paymentId);
		
		//System.err.println("payment status is not success ");
		//System.out.println("payment Not allowed for refund ");
		
		throw new IllegalArgumentException("payment not allowed for refund");
	}
	payment.setPaymentStatus("Refund");	
		payment.setTransactionId(UUID.randomUUID().toString());
		return repository.save(payment);	
	}
	

}
