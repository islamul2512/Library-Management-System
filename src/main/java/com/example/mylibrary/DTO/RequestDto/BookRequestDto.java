package com.example.mylibrary.DTO.RequestDto;

import com.example.mylibrary.enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequestDto {
    private String title;
    private Genre genre;
    private int noOfPage;
    private int price;
    private int authorId;
}
