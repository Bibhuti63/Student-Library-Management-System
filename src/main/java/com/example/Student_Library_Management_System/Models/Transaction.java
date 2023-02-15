package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transaction_details")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto set pk
    private int id;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private int fine;

    private String transactionId= UUID.randomUUID().toString(); //auto

    @CreationTimestamp //auto
    private Date transactionDate;

    private boolean isIssuedOperation;


    //Mapping

    //Transaction is child wrt Book//bcz for 1 Book multiple Transaction are there
    @ManyToOne //many transaction can done for one book
    @JoinColumn //by default the pk of book entity will be added as foreign key here
    private Book book; //this variable will be used for bidirectional mapping in parent class (Book)

    //Transaction is child w.r.t Card //bcz for 1 card multiple Transaction are there
    @ManyToOne
    @JoinColumn//by default pk of card will be foreign key here
    private Card card; //this variable will be used for bidirectional mapping in parent class(Card)

    //Constructor
    public Transaction() {
    }

    //setter & getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isIssuedOperation() {
        return isIssuedOperation;
    }

    public void setIssuedOperation(boolean issuedOperation) {
        isIssuedOperation = issuedOperation;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
