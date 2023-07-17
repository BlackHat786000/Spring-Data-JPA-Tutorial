package com.learn.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springdatajpa.entity.Course;
import com.learn.springdatajpa.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository repository;
	
	@Test
	public void saveCourseMaterial() {
		Course course = Course.builder()
				.title("Flutter")
				.credit(7)
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("flutter.com")
				.course(course)
				.build();
		
		repository.save(courseMaterial);
	}
	
	@Test
	public void printAllCourseMaterials() {
		List<CourseMaterial> courseMaterials = repository.findAll();
		System.out.println("Course Materials -> "+courseMaterials);
	}

}
