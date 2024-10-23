package com.telusko.spring_sec_demo.controllers;

import com.telusko.spring_sec_demo.model.Student;
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

    List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1,"Sahil","python"),
                    new Student(2,"Rohit","basic")
            )
    );

    @GetMapping("students")
    public List<Student> get(){
        return students;
    }

    @PostMapping("students")
    public String post(@RequestBody Student student){
        students.add(student);
        return "student added" + student;
    }

    @GetMapping("csrf")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
