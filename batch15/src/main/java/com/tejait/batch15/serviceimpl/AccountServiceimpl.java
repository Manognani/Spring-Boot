package com.tejait.batch15.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejait.batch15.dto.AccountCustomerDto;
import com.tejait.batch15.dto.AccountResponseDto;
import com.tejait.batch15.model.Account;
import com.tejait.batch15.repository.AccountRepository;

import com.tejait.batch15.service.AccountService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class AccountServiceimpl implements AccountService {
	
	
AccountRepository repository;	

	@Override
	public Account saveaccount(Account account) {
		account.setCreatedDate(LocalDateTime.now());
		account.setUpdatedDate(LocalDateTime.now());
	
		return repository.save(account) ;
	}

	@Override
	public Account getByAccountId(Long id) {
	
	return repository.findById(id).get();
	}

	@Override
	public AccountResponseDto getByCustomerInfoByAccountId(Long id) {
		Account account=repository.findById(id).get();
		AccountResponseDto dto=new AccountResponseDto();
		                   dto.setAccountId(account.getAccountId());
		                   dto.setAccountType(account.getAccountType());
		                   dto.setHolderName(account.getHolderName());
		                   dto.setIfsc(account.getIfsc());
		                   dto.setKycStatus(account.getKycStatus());
		return dto;
	}

	@Override
	public AccountCustomerDto getByCustomerDetails(Long id) {
		Account account=repository.findById(id).get();
		AccountCustomerDto dto=new AccountCustomerDto();
		                   dto.setAccountId(account.getAccountId());
		                   dto.setAccountNum(account.getAccountNum());
		                   dto.setBalance(account.getBalance());
		return dto;
	}


}
