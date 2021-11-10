package com.nateczhou.rock.repository;

import com.nateczhou.rock.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(value = "SELECT stu FROM Student stu WHERE stu.s_id = :id")
    Student getStudentById(String id);

    @Query(value = "SELECT stu FROM Student stu WHERE stu.name = :name")
    List<Student> getStudentByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO student (ID, name, dept_name, tot_cred) VALUES (:id, :name, :deptName, :totalCred);", nativeQuery = true)
    void insertStudent(@Param("id") String id,
                          @Param("name") String name,
                          @Param("deptName") String deptName,
                          @Param("totalCred") String totalCred);

}
