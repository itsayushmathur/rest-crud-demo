package com.itsayushmathur.restdemo.rest;

import com.itsayushmathur.restdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //define endpoint for "/students"

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Ayush","Mathur"));
        theStudents.add(new Student("Robb","Stark"));
        theStudents.add(new Student("Peter","Griffin"));
        theStudents.add(new Student("Nagato","Uzumaki"));

        return theStudents;
    }
}







