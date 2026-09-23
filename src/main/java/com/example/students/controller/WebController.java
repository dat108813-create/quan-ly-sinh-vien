package com.example.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/students")
    public String index() {
        return "students"; // Trả về file students.html trong src/main/resources/templates/
    }
}