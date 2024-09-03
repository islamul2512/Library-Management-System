package com.example.mylibrary.DTO.ResponsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorResponseDto {
    private int id;
    private String name;
    private int age;
}
