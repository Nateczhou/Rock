package com.nateczhou.rock.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @Column(name = "ID")
    private String s_id;

    @Column(name = "name")
    private String name;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "tot_cred")
    private String totalCred;

    @OneToMany(mappedBy = "stu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Takes> takes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return s_id.equals(student.s_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s_id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id='" + s_id + '\'' +
                ", name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", totalCred='" + totalCred + '\'' +
                '}';
    }
}
