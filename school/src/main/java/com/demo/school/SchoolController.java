package com.demo.school;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")

public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school){
        this.schoolService.saveStudent(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAll(){
        return ResponseEntity.ok(this.schoolService.findAllStudents());
    }
    @GetMapping("/with-student/{schoolId}")
    public ResponseEntity<SchoolWithStudentResponse> findWithStudent(@PathVariable(name = "schoolId") Integer schoolId){
        return ResponseEntity.ok(this.schoolService.findAllSchoolWithStudent(schoolId));
    }
}
