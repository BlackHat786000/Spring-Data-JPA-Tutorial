package com.learn.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.springdatajpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByFirstNameContaining(String name);
	
	public List<Student> findByLastNameNotNull();
	
	public List<Student> findByGuardianName(String guardianName);
	
	public Student findByFirstNameAndLastName(Student firstName, Student lastName);
	
	// JPQL
	@Query("select s from Student s where s.emailId=?1")
	public Student getStudentByEmailAddress(String emailAddress);
	
	// JPQL
	@Query("select s.firstName from Student s where s.emailId=?1")
	public String getStudentFirstNameByEmailAddress(String emailAddress);
	
	// Native Query
	@Query(
			value="SELECT * FROM tbl_student s where s.email_address=?1",
			nativeQuery=true
	)
	public Student getStudentByEmailAddressNative(String emailAddress);
	
	// Native Named Param
	@Query(
			value="SELECT * FROM tbl_student s where s.email_address=:email_id",
			nativeQuery=true
	)
	public Student getStudentByEmailAddressNativeNamedParam(@Param("email_id") String emailAddress);
	
	@Query(
			value="UPDATE tbl_student SET first_name=?1 WHERE email_address=?2",
			nativeQuery=true
	)
	@Modifying
	@Transactional
	public int updateStudentFirstNameByEmailAddress(String firstName, String emailAddress);

}
