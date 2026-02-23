package com.tejait.batch15.service;

import org.springframework.stereotype.Service;

import com.tejait.batch15.dto.AccountCustomerDto;
import com.tejait.batch15.dto.AccountResponseDto;
import com.tejait.batch15.model.Account;
@Service
public interface AccountService {

public	Account saveaccount(Account account);

public Account getByAccountId(Long id);

public AccountResponseDto getByCustomerInfoByAccountId(Long id);

public AccountCustomerDto getByCustomerDetails(Long id);



}
