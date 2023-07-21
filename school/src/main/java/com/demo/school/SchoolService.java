package com.demo.school;

import com.demo.school.client.StudentClient;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient client;
    @Autowired
    public SchoolService(SchoolRepository schoolRepository, StudentClient client) {
        this.schoolRepository = schoolRepository;
        this.client = client;
    }

    public void saveStudent(School school){
        this.schoolRepository.save(school);
    }

    public List<School> findAllStudents(){
        return this.schoolRepository.findAll();
    }
    public SchoolWithStudentResponse findAllSchoolWithStudent(Integer schoolId){
        var school = schoolRepository.findById(schoolId)
                .orElse(School.builder().name("NOT_FOUND").email("NOT_FOUND").build());
        var student = this.client.findAllStudentBySchool(schoolId); //find all students from student microservices
        return SchoolWithStudentResponse.builder().name(school.getName()).email(school.getEmail()).students(student).build();
    }

}
