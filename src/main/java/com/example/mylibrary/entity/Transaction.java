package com.example.mylibrary.entity;

import com.example.mylibrary.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="transactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String transactionNumber;

    @CreationTimestamp
    private Date transactionDate;

    private boolean isIssueOperation;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @ManyToOne
    @JoinColumn
    Card card;

    @ManyToOne
    @JoinColumn
    Book book;
}
