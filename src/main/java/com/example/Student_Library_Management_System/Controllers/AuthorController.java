package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author") // use of back slash (/) is optional
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String add(@RequestBody AuthorEntryDto authorEntryDto){
        return authorService.add(authorEntryDto);
    }

    @GetMapping("/all_books") //localhost:8080/author/all_books?author_id=1
    public List<String> findAllBook(@RequestParam("author_id") int id){
        return authorService.findAllBook(id);
    }

    //doubt : why i can not return list of objects as response??
//    @GetMapping("/all_books") //localhost:8080/author/all_books?author_id=1
//    public List<Book> findAllBook(@RequestParam("author_id") int id){
//        return authorService.findAllBook(id);
//    }

}
