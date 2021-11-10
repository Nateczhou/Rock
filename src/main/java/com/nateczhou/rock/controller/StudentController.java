package com.nateczhou.rock.controller;

import com.nateczhou.rock.entity.Student;
import com.nateczhou.rock.model.StudentDTO;
import com.nateczhou.rock.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
//    @GetMapping("/student/{id}")
//    public Optional<Student> getUser(@PathVariable("id") String id) {
//        return studentRepository.findById(id);
//    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") String id) {
        ResponseEntity<StudentDTO> response = studentService.getStudentById(id);
        if (response == null) {
            throw new NullPointerException();
        }
        return response;
    }

//    @GetMapping("/student")
//    public List<Student> getStudentByName(String name) {
//        return studentRepository.getStudentByName(name);
//    }

    @PostMapping(value = "/student", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> insertStudent(@RequestBody Student s) {
        return studentService.insertStudent(s);

    }


}

