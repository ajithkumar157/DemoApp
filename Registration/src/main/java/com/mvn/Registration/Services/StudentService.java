package com.mvn.Registration.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvn.Registration.Entity.Course;
import com.mvn.Registration.Entity.Student;
import com.mvn.Registration.Repository.CourseRepository;
import com.mvn.Registration.Repository.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

    public Student addStudent(Student student) {
        // Check if the student is already registered
        Optional<Student> existingStudent = studentRepo.findByEmail(student.getEmail());
        if (existingStudent.isPresent()) {
            throw new RuntimeException("Student with email " + student.getEmail() + " is already registered!");
        }

        // Check if the technology exists in the Course table
        Optional<Course> matchingCourse = courseRepo.findByName(student.getTechnology());
        if (matchingCourse.isEmpty()) {
            throw new RuntimeException("Invalid technology: " + student.getTechnology() + ". Please choose from available courses.");
        }

        // If both checks pass, save the student
        return studentRepo.save(student);
    }

    public List<Student> getAllEnrolledStudents() {
        return studentRepo.findAll();
    }
}

