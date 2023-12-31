package com.learn.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.learn.springdatajpa.entity.Course;
import com.learn.springdatajpa.entity.Student;
import com.learn.springdatajpa.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository repository;
	
	@Test
	public void printAllCourses() {
		List<Course> courses = repository.findAll();
		System.out.println("Courses -> "+courses);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("Tarun")
				.lastName("Yadav")
				.build();
		
		Course course = Course.builder()
				.title("Javascript")
				.credit(9)
				.teacher(teacher)
				.build();
		
		repository.save(course);
	}
	
	@Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
		
		List<Course> courses = repository.findAll(secondPageWithTwoRecords).getContent();
		
		long totalElements = repository.findAll(secondPageWithTwoRecords).getTotalElements();
		
		long totalPages = repository.findAll(secondPageWithTwoRecords).getTotalPages();
		
		System.out.println("total elements: "+totalElements);
		System.out.println("total pages: "+totalPages);
		System.out.println("courses: "+courses);
	}
	
	@Test
	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
		List<Course> courses = repository.findAll(sortByTitle).getContent();
		System.out.println("courses: "+courses);
	}
	
	@Test
	public void printFindByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		List<Course> courses = repository.findByTitleContaining("F", firstPageTenRecords).getContent();
		System.out.println("courses: "+courses);
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("Rajkumar")
				.lastName("Rao")
				.build();
		
		Student student = Student.builder()
				.firstName("MS")
				.lastName("Dhoni")
				.emailId("dhoni@csk.com")
				.build();
		
		Course course = Course.builder()
				.title("Machine Learning")
				.credit(12)
				.teacher(teacher)
				.build();
		
		course.addStudents(student);
		
		repository.save(course);
	}

}
