package com.nateczhou.rock.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class StudentDTO {
    private String id;
    private String name;
    private String dept;
}

