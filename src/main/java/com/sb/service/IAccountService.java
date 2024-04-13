package com.sb.service;

import java.util.Optional;

import com.sb.model.Account;

public interface IAccountService {

	public Account createAccount(Account account);
	public Optional<Account> getAccount(Long accountId);
	public Account deposit(Long accountId, Double amount);
	public Account withdraw(Long accountId, Double amount);
	
	
}
