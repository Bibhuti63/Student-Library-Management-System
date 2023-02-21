package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.DTOs.BookResponseDto;
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

    public AuthorResponseDto getAuthor(int id) {
        Author author=authorRepository.findById(id).get();
        AuthorResponseDto authorResponseDto=new AuthorResponseDto();

        List<Book>booksWritten=author.getBooksWritten();
        List<BookResponseDto>bookResponseList=new ArrayList<>();

        for(Book b: booksWritten){
            BookResponseDto temp=new BookResponseDto();
            temp.setGenre(b.getGenre());
            temp.setName(b.getName());
            temp.setPage(b.getPages());
            temp.setRating(b.getRating());

            //adding bookResponse to the list
            bookResponseList.add(temp);
        }
        //set attribute of author
        authorResponseDto.setBookList(bookResponseList);
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setCountry(author.getCountry());
        authorResponseDto.setName(author.getName());

        return authorResponseDto;
    }





//    public List<Book> findAllBook(int id) {
//        Author author=authorRepository.findById(id).get();
//
//        List<Book>books=author.getBooksWritten();
//
//        return books;
//    }

}
