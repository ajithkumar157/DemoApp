package com.mvn.Registration.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvn.Registration.Entity.Course;
import com.mvn.Registration.Repository.CourseRepository;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo; 

    @PostConstruct
    public void loadDefaultCourses() {
        if (courseRepo.count() == 0) {  // Ensure data is only added once
            courseRepo.save(new Course("Java", "3 Months"));
            courseRepo.save(new Course("Python", "4 Months"));
            courseRepo.save(new Course("Web Development", "6 Months"));
        }
    }

    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }
}
