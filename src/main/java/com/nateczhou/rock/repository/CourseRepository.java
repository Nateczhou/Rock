package com.nateczhou.rock.repository;

import com.nateczhou.rock.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

//    @Query(value = "SELECT c FROM Course c WHERE c.id = :id")
//    Course getCourseById(@PathVariable("id") String id);

    @Query("SELECT c " +
            "FROM Course c INNER JOIN fetch c.takes t WHERE t.stu.s_id = :id")

    List<Course> getCourseTakenById(@Param("id") String id);

}
