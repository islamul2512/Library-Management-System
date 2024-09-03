package com.example.mylibrary.DTO.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReturnBookRequestDto {
    private int cardId;

    private int bookId;
}
