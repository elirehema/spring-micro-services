package com.demo.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void saveStudent(Student student){
        this.studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return this.studentRepository.findAll();
    }
    public List<Student> findBySchoolId(Integer schoolId){
        return this.studentRepository.findAllBySchoolId(schoolId);
    }
}
