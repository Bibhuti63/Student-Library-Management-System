package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

//    public List<String> getBookIssuedToCard(int id) {
//        Card card=cardRepository.findById(id).get();
//        List<Book>list=card.getBooksIssued();
//
//        System.out.println("printing the list of books for id");
//        for(Book b: list){
//            System.out.println(b.getName());
//        }
//
//        List<String>books=new ArrayList<>();
//        for(Book b : list){
//            String name=b.getName();
//            books.add(name);
//        }
//        //test
//        System.out.println("hello world size of the list is"+books.size());
//        for(String str: books) System.out.println(str);
//
//        return books;
//    }
    public List<String> getBookIssuedToCard(int id) {
        Card card=cardRepository.findById(id).get();
        List<String>books=new ArrayList<>();


        return books;
    }

//    public String getBookIssuedToCard(int id) {
//        Card card=cardRepository.findById(id).get();
//        List<Book>list=card.getBooksIssued();
//        StringBuilder sb=new StringBuilder();
//        for(Book b : list){
//            String name=b.getName();
//            sb.append(name);
//            sb.append(", ");
//        }
//        return sb.toString();
//    }

}
