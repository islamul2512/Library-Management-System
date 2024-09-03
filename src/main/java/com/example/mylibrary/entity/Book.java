package com.example.mylibrary.entity;

import com.example.mylibrary.enums.Genre;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int noOfPage;
    private int price;

    private boolean isIssued;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    Author author;


    @ManyToOne
    @JoinColumn
    Card card;


    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();

}
