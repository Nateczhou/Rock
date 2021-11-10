package com.nateczhou.rock.controller;

import com.nateczhou.rock.entity.Department;
import com.nateczhou.rock.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/department/{s_id}")
    public Department getDeptInfoByName(@PathVariable("s_id") String id) {
        return departmentRepository.getDeptInfoById(id);
    }


}
