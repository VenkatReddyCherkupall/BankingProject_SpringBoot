package com.sb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.model.Account;
import com.sb.repo.IAccountRepo;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountRepo accountRepo;

	@Override
	public Account createAccount(Account account) {
		return accountRepo.save(account);

	}

	@Override
	public Optional<Account> getAccount(Long accountId) {

		return accountRepo.findById(accountId);
	}

	@Override
	public Account deposit(Long accountId, Double amount) {

		Account account = getAccount(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
		//Account account = accountRepo.getById(accountId);
		Double accountTotalAfterDeposit = account.getAccountBalance() + amount;
		account.setAccountBalance(accountTotalAfterDeposit);
		return accountRepo.save(account);
	}

	@Override
	public Account withdraw(Long accountId, Double amount) {
		//Account account = accountRepo.getById(accountId);
		Account account = getAccount(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
		if (account.getAccountBalance() <= amount) {
			System.out.println("Insuffecient balance");
		}else {			
			Double accountTotalAfterWithdraw = account.getAccountBalance() - amount;
			account.setAccountBalance(accountTotalAfterWithdraw);
		}
		return accountRepo.save(account);
	}

}
