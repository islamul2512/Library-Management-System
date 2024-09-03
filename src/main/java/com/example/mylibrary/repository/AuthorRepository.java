package com.example.mylibrary.repository;

import com.example.mylibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findByEmail(String email);
}
