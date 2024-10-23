package com.telusko.spring_sec_demo.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping({"hello","/"})
    public String hello(HttpServletRequest request){
        return "hello world  " + request.getSession().getId();
    }

    @GetMapping("about")
    public String about(HttpServletRequest request){
        return "about app" + request.getSession().getId();
    }
}
