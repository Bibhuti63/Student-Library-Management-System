package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;



    public String add(AuthorEntryDto authorEntryDto) {

        //here provided object is of DTO type but repository layer deals with entities
        //Solution: Convert authorEntryDto to Author

        //create object of type Author
        Author author=new Author();
        //set attributes of object
        author.setAge(authorEntryDto.getAge());
        author.setName(authorEntryDto.getName());
        author.setCountry(authorEntryDto.getCountry());

        authorRepository.save(author);

        return "Author added to database";
    }

    public List<String> findAllBook(int id) {
        Author author=authorRepository.findById(id).get();

        List<Book>books=author.getBooksWritten();
        List<String>bookNames=new ArrayList<>();

        for(Book book: books){
            String name=book.getName();
            bookNames.add(name);
        }
        return bookNames;

    }

    public Author getAuthor(int id) {
        return authorRepository.findById(id).get();
    }
//    public List<Book> findAllBook(int id) {
//        Author author=authorRepository.findById(id).get();
//
//        List<Book>books=author.getBooksWritten();
//
//        return books;
//    }

}
