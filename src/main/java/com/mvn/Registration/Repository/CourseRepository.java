package com.mvn.Registration.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvn.Registration.Entity.Course;


public interface CourseRepository extends JpaRepository<Course, Integer> {
	   Optional<Course> findByName(String name);
}
