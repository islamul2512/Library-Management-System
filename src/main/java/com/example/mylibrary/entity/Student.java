package com.example.mylibrary.entity;

import com.example.mylibrary.enums.Department;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String mobNo;
    private String email;
    @OneToOne(mappedBy = "student" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    Card card;

}
