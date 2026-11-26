package com.crud.teacher.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.teacher.dto.AccountTransfer;
import com.crud.teacher.dto.AccountsShow;
import com.crud.teacher.entity.Accounts;
import com.crud.teacher.service.AccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/accounts")
@AllArgsConstructor
public class AccountController {

	private AccountService service;

	@GetMapping
	public ResponseEntity<List<AccountsShow>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllAccounts());
	}

	@PostMapping
	public ResponseEntity<Accounts> register(@RequestBody Accounts a) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.registerAccount(a));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Accounts> getOne(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
	}

	@PutMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestBody AccountTransfer transfer) {
		service.transfer(transfer);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Success..");
	}
}
