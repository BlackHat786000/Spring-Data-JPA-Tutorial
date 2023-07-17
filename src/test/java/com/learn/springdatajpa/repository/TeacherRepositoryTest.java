package com.learn.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springdatajpa.entity.Course;
import com.learn.springdatajpa.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository repository;
	
	@Test
	public void saveTeacher() {
		Course courseDSA = Course.builder()
				.title("Data Structures")
				.credit(8)
				.build();
		Course courseJava = Course.builder()
				.title("Java")
				.credit(5)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Anil")
				.lastName("Sharma")
//				.courses(List.of(courseDSA, courseJava))
				.build();
		
		repository.save(teacher);
	}

}
