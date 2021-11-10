package com.nateczhou.rock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class CourseDTO {
    private String courseId;
    private String title;
    private String dept;
    private String credits;
}
