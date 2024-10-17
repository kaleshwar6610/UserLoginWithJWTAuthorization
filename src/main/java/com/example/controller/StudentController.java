package com.example.controller;

import com.example.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/welcome")
    public String welcomePage(HttpServletRequest request){

        return "Welcome page for users " + request.getSession().getId();
    }

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1L, "fury", 87),
            new Student(2L, "navin", 66)
    ));

    @GetMapping("/student")
    public List<Student> getStudentsList(){
        return students;
    }



    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

    //with spring security we can use GetMapping but all the
    // other api's like Post, update, delete we cannot do it
    // because of hidden csrf token
    //So we have to get the csrf-Token and add it in the headers of postmapping http method
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
