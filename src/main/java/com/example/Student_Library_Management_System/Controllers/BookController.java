package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String add(@RequestBody Book book){ //all attribute provide , only author id provided, card not provided
        return bookService.add(book);
    }


}
