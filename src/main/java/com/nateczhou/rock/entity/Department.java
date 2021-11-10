package com.nateczhou.rock.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "building")
    private String building;

    @Column(name = "budget")
    private String budget;


}
