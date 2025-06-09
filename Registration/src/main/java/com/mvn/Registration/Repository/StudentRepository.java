package com.mvn.Registration.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvn.Registration.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Optional<Student> findByEmail(String email);
}


