package com.nateczhou.rock.service.implementation;

import com.nateczhou.rock.entity.Student;
import com.nateczhou.rock.model.StudentDTO;
import com.nateczhou.rock.repository.StudentRepository;
import com.nateczhou.rock.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<StudentDTO> getStudentById(String id) {
        Student stu = studentRepository.getStudentById(id);
        StudentDTO dto = new StudentDTO(stu.getS_id(), stu.getName(), stu.getDeptName());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public ResponseEntity<Student> insertStudent(Student stu) {
        Student student = studentRepository.insertStudent(stu.getS_id(),stu.getDeptName(),stu.getName(),stu.getTotalCred());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


}
