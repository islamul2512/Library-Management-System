package com.example.mylibrary.DTO.ResponsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.TransactionStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReturnBookResponseDto {
    private String transactionNumber;


    //private TransactionStatus transactionStatus;

    private String bookName;
}
