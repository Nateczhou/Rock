package com.nateczhou.rock.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "course")
@Data
public class Course {
    @Id
    @Column(name = "course_id")
    private String c_id;

    @Column(name = "dept_name")
    private String dept_name;

    @Column(name = "title")
    private String title;

    @Column(name = "credits")
    private String credits;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Takes> takes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(c_id, course.c_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c_id);
    }
}
