package com.demo.school;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolWithStudentResponse {
    private String name;
    private String email;
    List<Student> students;
}
