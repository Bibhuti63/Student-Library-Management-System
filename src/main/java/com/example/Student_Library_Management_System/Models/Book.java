package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.Genre;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double rating;
    private int pages;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    //Mapping

        //1
        //Book & Author mapping
        //here Book is child w.r.t Author
    @ManyToOne
    @JoinColumn //here by default author id will be used as foreign key for this table
    private Author author; //this will be used in parent class (Author) for bidirectional mapping

        //2
        //Book & Card mapping
        //here Book is child w.r.t Card//bcz book can not issued without Card
    @ManyToOne
    @JoinColumn//here by default card id will used as foreign key fot this table
    private Card card; //this will be used in parent class (Card) for bidirectional mapping




    //constructor
    public Book() {
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
