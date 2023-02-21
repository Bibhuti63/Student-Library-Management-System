package com.example.Student_Library_Management_System.DTOs;

import java.util.List;

public class AuthorResponseDto {
    String name;
    int age;
    String country;
    List<BookResponseDto>bookList;

    public AuthorResponseDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<BookResponseDto> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookResponseDto> bookList) {
        this.bookList = bookList;
    }
}
