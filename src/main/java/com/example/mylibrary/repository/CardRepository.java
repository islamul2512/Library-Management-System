package com.example.mylibrary.repository;

import com.example.mylibrary.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
