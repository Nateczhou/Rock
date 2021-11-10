package com.nateczhou.rock.service;

import com.nateczhou.rock.entity.Student;
import com.nateczhou.rock.model.StudentDTO;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<StudentDTO> getStudentById(String id);

    ResponseEntity<Student> insertStudent(Student stu);
}
