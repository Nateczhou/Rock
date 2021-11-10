package com.nateczhou.rock.repository;

import com.nateczhou.rock.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(value = "SELECT stu FROM Student stu WHERE stu.s_id = :id")
    Student getStudentById(String id);

    @Query(value = "SELECT stu FROM Student stu WHERE stu.name = :name")
    List<Student> getStudentByName(@Param("name") String name);

    @Query(value = "update Student s SET s.s_id = :id, s.deptName = :deptName, s.name = :name, s.totalCred = :totalCred")
    Student insertStudent(@Param("id") String id,
                          @Param("deptName") String deptName,
                          @Param("name") String name,
                          @Param("totalCred") String totalCred);

}
