package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.IssueBookRequestDto;
import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Transaction;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import com.example.Student_Library_Management_System.Repositories.CardRepository;
import com.example.Student_Library_Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;


    public String issueBook(IssueBookRequestDto issueBookRequestDto) {
        //write the logic to issue book here

        //fetching the respective repository to get the object
        Book book=bookRepository.findById(issueBookRequestDto.getBookId()).get();
        Card card=cardRepository.findById(issueBookRequestDto.getCardId()).get();

        //marking the given book as issued
        book.setIssued(true);

        //creating a new transaction
        Transaction transaction=new Transaction();
        //id(p.k), transactionDate,transactionId(uuid) is auto set
        //set other parameters
        transaction.setIssuedOperation(true);
        transaction.setFine(0);
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        //set the foreign keys
        transaction.setBook(book);
        transaction.setCard(card);

        //adding the transaction to book
        book.getTransactionList().add(transaction); //it will update in the reference so no need to get the list , add, then update
        //adding the transaction to card
        card.getTransactionList().add(transaction);

        //adding the book to list_of_book_issued using the card
        card.getBooksIssued().add(book);

        //save the card, book, transaction entity

        //card is parent of transaction //also it is parent of book
        //saving the card will save book & transaction by cascading effect

        cardRepository.save(card);

        return "Book : "+" "+book.getName()+" issued to Card No :"+card.getId()+" Tnx id "+transaction.getTransactionId();
    }
}
