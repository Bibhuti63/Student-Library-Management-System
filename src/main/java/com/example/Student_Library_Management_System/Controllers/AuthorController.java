package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author") // use of back slash (/) is optional
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String add(@RequestBody AuthorEntryDto authorEntryDto){
        return authorService.add(authorEntryDto);
    }
}
