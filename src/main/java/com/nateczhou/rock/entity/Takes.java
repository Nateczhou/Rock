package com.nateczhou.rock.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "takes")
@Data
public class Takes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    private Student stu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    @Column(name = "sec_id")
    private String secId;

    @Column(name = "semester")
    private String semester;

    @Column(name = "year")
    private int year;

    @Column(name = "grade")
    private String grade;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Takes takes = (Takes) o;
        return year == takes.year && uid.equals(takes.uid) && stu.equals(takes.stu) && course.equals(takes.course) && secId.equals(takes.secId) && semester.equals(takes.semester) && Objects.equals(grade, takes.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, stu, course, secId, semester, year, grade);
    }
}
