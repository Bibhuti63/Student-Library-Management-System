package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
//import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    public String add(Book book) {

        //as only author id is passed in the object get it
        int author_id=book.getAuthor().getId();
        //fetch author enity using author_id
        Author author= authorRepository.findById(author_id).get();

        //H.W : do the exception handling

        //set the foreign key attribute in child class
        book.setAuthor(author);

        //update list of book written by author
        List<Book>list=author.getBooksWritten();
        list.add(book);


        //Now the book is to be saved, but also author is also need to be saved.

        //Why do we need to again save (updating) the author ?? bcz
        //bcz the author Entity has been updated....we need to resave/update it.

        authorRepository.save(author);

        //.save function works both as save function and as update function

        //bookRepo.save is not required : bcz it will be autocalled by cascading effect

        return "Book added to database";
    }
}
