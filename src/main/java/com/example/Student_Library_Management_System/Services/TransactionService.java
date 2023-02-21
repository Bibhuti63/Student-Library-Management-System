package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.IssueBookRequestDto;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Transaction;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import com.example.Student_Library_Management_System.Repositories.CardRepository;
import com.example.Student_Library_Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;


    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        //fetching the respective repository to get the object
        Book book=bookRepository.findById(issueBookRequestDto.getBookId()).get();
        Card card=cardRepository.findById(issueBookRequestDto.getCardId()).get();

//        book.setIssued(true);

        //create a new transaction
        Transaction transaction=new Transaction();
        transaction.setBook(book);
        transaction.setCard(card);

        transaction.setFine(0);
//        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIssuedOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        if(book==null){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available in library");

        }

        if(card==null || (card.getCardStatus()!= CardStatus.ACTIVATED)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not valid");
        }

        //sucess case
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);

        //adding to list of book issued to card
        card.getBooksIssued().add(book);

        //adding transaction to list of transaction of card
        card.getTransactionList().add(transaction);

        //adding transaction to list of transaction of book
        book.getTransactionList().add(transaction);

        cardRepository.save(card);

        return "Book : "+book.getName()+" issued to card id : "+card.getId()+" tnx id : "+transaction.getTransactionId();

    }
}
