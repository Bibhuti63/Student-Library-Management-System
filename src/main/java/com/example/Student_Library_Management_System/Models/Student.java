package com.example.Student_Library_Management_System.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_info")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generated id & use as primary key
    private int id;
    private String name;
    private int age;
    private String country;
    private String mobileNo;
    @Column(unique = true) //unique key
    private String email;

    //Bidirectional maping
        //mappedBy = (name of variable which is of type parent(Student) i.e used in child class(Card) as foreign key)
        //cascade -> make sure that if parent is changed child will also change to avoid redundancy
    @OneToOne(mappedBy = "studentVariableName",cascade = CascadeType.ALL)
    private Card card;
    //its required to have getters and setter of card variable

    /*
      Steps to find that variable
        1. Go the child class (In this case: Card)
        2. Out of all the attributes select the foreign key attribute that is helping you connect with parent class
        (Ref :  @OneToOne
                @JoinColumn
                private Student studentVariableName;
        )
        3. Choose the variable name of the parentEnty (reference : studentVariableName)
     */

    //constructor
    public Student() {
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
