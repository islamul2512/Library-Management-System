package com.example.mylibrary.DTO.ResponsDto;

import com.example.mylibrary.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllBookResponseDto {
    private int id;
    private String title;
    private Genre genre;
    private int noOfPage;
    private int price;
}
