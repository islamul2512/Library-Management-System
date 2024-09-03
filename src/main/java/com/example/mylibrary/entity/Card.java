package com.example.mylibrary.entity;

import com.example.mylibrary.enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private Date issueDate;
    @UpdateTimestamp
    private Date updatedOn;
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;
    private String validTill;
    @OneToOne
    @JoinColumn
    @JsonBackReference
    Student student;



    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> booksIssued = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();


}
