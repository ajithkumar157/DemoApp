package com.mvn.Registration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvn.Registration.Entity.Course;
import com.mvn.Registration.Entity.Student;
import com.mvn.Registration.Services.CourseService;
import com.mvn.Registration.Services.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost") // Allow frontend requests
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Register a new student
    @PostMapping("/add/student")
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // Get all enrolled students
    @GetMapping("/enrolled")
    public List<Student> getAllStudents() {
        return studentService.getAllEnrolledStudents();
    }
}


