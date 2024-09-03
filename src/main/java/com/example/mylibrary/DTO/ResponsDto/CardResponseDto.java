package com.example.mylibrary.DTO.ResponsDto;

import com.example.mylibrary.enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardResponseDto {
    private int id;

    private Date issueDate;

    private Date updatedOn;

    private CardStatus cardStatus;

    private String validTill;
}
