package com.demo.student;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student){
        this.studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(this.studentService.findAllStudents());
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> findAllBySchoolId(@PathVariable(name = "schoolId") Integer schoolId){
        return ResponseEntity.ok(this.studentService.findBySchoolId(schoolId));
    }
}
