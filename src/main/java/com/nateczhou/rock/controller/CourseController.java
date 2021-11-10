package com.nateczhou.rock.controller;

import com.nateczhou.rock.entity.Course;
import com.nateczhou.rock.model.CourseDTO;
import com.nateczhou.rock.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    private CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

//    @GetMapping("/course/{id}")
//    public Course getCourseById(@PathVariable("id") String id) {
//        return courseRepository.getCourseById(id);
//    }

    @GetMapping("/course/{id}")
    public ResponseEntity<List<CourseDTO>> getCourseTakenById(@PathVariable("id") String id) {
        List<Course> input = courseRepository.getCourseTakenById(id);
        List<CourseDTO> courses = new ArrayList<>();
        for (Course c: input) {
            courses.add(new CourseDTO(c.getC_id(),c.getTitle(),c.getDept_name(),c.getCredits()));
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}

