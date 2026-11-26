package com.crud.teacher.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.teacher.entity.Teacher;
import com.crud.teacher.repository.TeacherRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherService {

	private TeacherRepository repo;

	public List<Teacher> getAllTeachers() {
		return repo.findAll();
	}

	public Teacher getOne(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
	}

	public Teacher saveTeacher(Teacher t) {
		return repo.save(t);
	}

	public Teacher updateTeacher(Long id, Teacher t) {
		Teacher tc = getOne(id);
		tc.setName(t.getName());
		tc.setCourseName(t.getCourseName());
		tc.setQualification(t.getQualification());

		return repo.save(tc);
	}

	public String deleteTeacher(Long id) {
		repo.deleteById(id);
		return "Delete " + id + " sucessfully.. ";
	}
}
