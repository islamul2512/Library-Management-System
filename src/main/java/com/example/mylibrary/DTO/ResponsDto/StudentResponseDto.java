package com.example.mylibrary.DTO.ResponsDto;

import com.example.mylibrary.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponseDto {
    private int id;

    private String name;

    private int age;

    private Department department;

    private String mobNo;
    private String email;

    CardResponseDto cardResponseDto;
}
