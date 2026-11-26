package com.crud.teacher.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.teacher.entity.Teacher;
import com.crud.teacher.service.TeacherService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/teacher")
@AllArgsConstructor
public class TeacherController {

	private TeacherService service;

	@GetMapping
	public ResponseEntity<List<Teacher>> getAll() {
//		return service.getAllTeachers();
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllTeachers());
	}

	@PostMapping
	public ResponseEntity<Teacher> save(@RequestBody Teacher t) {
//		return service.saveTeacher(t);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveTeacher(t));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Teacher> getOneTeacher(@PathVariable Long id) {
//		return service.getOne(id);
		return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
	}

	@PutMapping("/{id}")
	public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher t) {
		return service.updateTeacher(id, t);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTeacher(@PathVariable Long id) {
//		return service.deleteTeacher(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.deleteTeacher(id));
	}
}
