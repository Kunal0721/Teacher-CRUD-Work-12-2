package com.crud.teacher.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.teacher.entity.Users;
import com.crud.teacher.service.UsersService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UsersController {

	private UsersService service;

	@GetMapping
	public ResponseEntity<Page<Users>> getAllUsers(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllUsers(pageNo, pageSize));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Users> getOne(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
	}
}
