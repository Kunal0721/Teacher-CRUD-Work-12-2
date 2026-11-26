package com.crud.teacher.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crud.teacher.entity.Users;
import com.crud.teacher.repository.UsersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsersService {

	private UsersRepository repo;

	public Page<Users> getAllUsers(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return repo.findAll(pageable);
	}

	public Users getOne(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found : " + id));
	}

}
