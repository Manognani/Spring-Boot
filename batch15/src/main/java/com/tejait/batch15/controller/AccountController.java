package com.tejait.batch15.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.dto.AccountCustomerDto;
import com.tejait.batch15.dto.AccountResponseDto;
import com.tejait.batch15.model.Account;
import com.tejait.batch15.service.AccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/account")
@AllArgsConstructor // Instead of @autowired give annotation @AllArgsConstructor through lombock
public class AccountController {
	
	AccountService service;	

@PostMapping("/saveAccount")	
   public ResponseEntity<Account> saveAccount(@RequestBody Account account){
	Account savedaccount=service.saveaccount(account);
	return new ResponseEntity<>(savedaccount,HttpStatus.CREATED) ;
	
}
@GetMapping("/getById/{id}")
public ResponseEntity<Account> getByIdAccountDtls(@PathVariable Long  id) {
	   Account account=service.getByAccountId(id);
 return new ResponseEntity<>(account,HttpStatus.OK);
	
}
     @GetMapping("/getByAccId/{id}")
   public ResponseEntity<AccountResponseDto> giveCustomerAccountInfo(@PathVariable Long id){
	 AccountResponseDto dto=service.getByCustomerInfoByAccountId(id);
	 return new ResponseEntity<>(dto, HttpStatus.OK);
}
     @GetMapping("/getByCustomerId/{id}")
	public ResponseEntity<AccountCustomerDto> getCustomerAccountInfo(@PathVariable Long id) {
		AccountCustomerDto dto=service.getByCustomerDetails(id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
		
	

}
