package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
//import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    public String add(BookRequestDto bookRequestDto) {
        //As the provided parameter is in form of dto but repository deals with entities only
        //soulution : convert bookRequestDto to Book
        int author_id=bookRequestDto.getAuthorId();

        //fetch author enity using author_id
        Author author= authorRepository.findById(author_id).get();

        //creating a new book object
        Book book=new Book();
        //setting the basic attribute ok book object
        book.setPages(bookRequestDto.getPages());
        book.setGenre(bookRequestDto.getGenre());
        book.setName(bookRequestDto.getName());
        book.setRating(bookRequestDto.getRating());
        book.setIssued(false);

        book.setAuthor(author);

        //adding the book to authors book list
        List<Book> booksWritten=author.getBooksWritten();
        booksWritten.add(book);


        //Now the book is to be saved, but also author is also need to be saved.

        //Why do we need to again save (updating) the author ?? bcz
        //bcz the author Entity has been updated....we need to resave/update it.

        authorRepository.save(author);

        //.save function works both as save function and as update function

        //bookRepo.save is not required : bcz it will be auto called by cascading effect

        return "Book added to database";
    }
}
