package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student") //its used to map the http request to a perticular controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student studet){
        return studentService.addStudent(studet);

    }

    @GetMapping("/getStudentNameByEmail") //localhost:8080/student/getStudentNameByEmail?email=biswalbibhuti8@gmail.com
    public String getStudentNameByEmail(@RequestParam("email") String email){
        return studentService.getStudentNameByEmail(email);
    }

    @GetMapping("/getStudentFromCountry")
    public List<String> getStudentFromCountry(@RequestParam("country") String country){
        return studentService.getStudentFromCountry(country);
    }

//    @GetMapping("/ageBetween")
//    public List<String> getStudentBetweenAge(@RequestParam("age") int age){
//        return studentService.getStudentBetweenAge(age);
//    }

}
