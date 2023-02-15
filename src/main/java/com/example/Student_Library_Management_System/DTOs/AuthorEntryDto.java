package com.example.Student_Library_Management_System.DTOs;

//this is just an object used to take request from post man
public class AuthorEntryDto {
    //it will contain parameter that we want to send from postman
  //Note that here we dont have id
    private String name;
    private int age;
    private String country;


    public AuthorEntryDto() {
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

}
