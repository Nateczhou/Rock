package com.nateczhou.rock.repository;

import com.nateczhou.rock.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Query("SELECT dept FROM Department dept, Student stu WHERE stu.deptName = dept.deptName AND stu.s_id = :id")
    Department getDeptInfoById(@Param("id") String id);
}
