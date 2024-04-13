package com.sb.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.model.Account;
import com.sb.service.AccountServiceImpl;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl accountServiceImpl;

	@PostMapping
	public Account createAccount(@RequestBody Account account) {

		return accountServiceImpl.createAccount(account);

	}

	@GetMapping("/{id}")
	public Optional<Account> getAccount(@PathVariable Long id) {
		return accountServiceImpl.getAccount(id);
	}

	@PostMapping("/{id}/deposit")
	public Account depoist(@PathVariable Long id, @RequestBody Map<String, Double> request ) {
		Double amount = request.get("amount");
		return accountServiceImpl.deposit(id, amount);

	}

	@PostMapping("/{id}/withdraw")
	public Account withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request) {
		Double amount = request.get("amount");
		return accountServiceImpl.withdraw(id, amount);
	}
}
