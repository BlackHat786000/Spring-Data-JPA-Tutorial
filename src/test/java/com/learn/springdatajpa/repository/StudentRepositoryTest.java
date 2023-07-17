package com.learn.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springdatajpa.entity.Guardian;
import com.learn.springdatajpa.entity.Student;

@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailId("yadavgoldy786@gmail.com")
				.firstName("Goldy")
				.lastName("Yaduvanshi")
//				.guardianName("DP Yadav")
//				.guardianEmail("dp_yadav@gmail.com")
//				.guardianMobile("8715684621")
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder()
				.name("Dharm")
				.email("dharm@gmail.com")
				.mobile("786")
				.build();
		
		Student student = Student.builder()
				.firstName("Indra")
				.lastName("Yadav")
				.emailId("indra@gmail.com")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void printAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println("Students list -> "+studentList);
	}
	
	@Test
	public void printStudentsByFirstName() {
		List<Student> studentList = studentRepository.findByFirstName("Udit");
		System.out.println("Students list -> "+studentList);
	}
	
	@Test
	public void printStudentsByFirstNameContaining() {
		List<Student> studentList = studentRepository.findByFirstNameContaining("In");
		System.out.println("Students list -> "+studentList);
	}
	
	@Test
	public void printStudentsByGuardianName() {
		List<Student> studentList = studentRepository.findByGuardianName("DP Yadav");
		System.out.println("Students list -> "+studentList);
	}
	
	@Test
	public void printStudentByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("indra@gmail.com");
		System.out.println("Student -> "+student);
	}
	
	@Test
	public void printStudentFirstNameByEmailAddress() {
		String firstName = studentRepository.getStudentFirstNameByEmailAddress("indra@gmail.com");
		System.out.println("First Name -> "+firstName);
	}
	
	@Test
	public void printStudentByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailAddressNative("yadavgoldy786@gmail.com");
		System.out.println("Student -> "+student);
	}
	
	@Test
	public void printStudentByEmailAddressNativeNamedParam() {
		Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("yadavudit786@gmail.com");
		System.out.println("Student -> "+student);
	}
	
	@Test
	public void updateStudentFirstNameByEmailAddress() {
		studentRepository.updateStudentFirstNameByEmailAddress("Indra the tiger", "indra@gmail.com");
	}

}
