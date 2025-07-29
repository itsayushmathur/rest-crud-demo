package com.itsayushmathur.restdemo.rest;

import com.itsayushmathur.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Ayush", "Mathur"));
        theStudents.add(new Student("Robb", "Stark"));
        theStudents.add(new Student("Peter", "Griffin"));
        theStudents.add(new Student("Nagato", "Uzumaki"));

    }
    //define endpoint for "/students"

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    //define endpoint for "/students/{studentId" -return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //just index into the list
        //check the studentId against the list size

        if(studentId>=theStudents.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
        }
        return theStudents.get(studentId);
    }

    //Add an exception handler usign @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(String.valueOf(System.currentTimeMillis()));

        //return responseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //add an exception handler for all exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("The params do not match the expected input. Please Check the input and try again.");
        error.setTimeStamp(String.valueOf(System.currentTimeMillis()));

        //return responseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}







