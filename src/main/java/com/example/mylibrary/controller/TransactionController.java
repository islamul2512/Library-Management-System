package com.example.mylibrary.controller;

import com.example.mylibrary.DTO.RequestDto.IssueBookRequestDto;
import com.example.mylibrary.DTO.RequestDto.ReturnBookRequestDto;
import com.example.mylibrary.DTO.ResponsDto.IssueBookResponseDto;
import com.example.mylibrary.DTO.ResponsDto.ReturnBookResponseDto;
import com.example.mylibrary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public IssueBookResponseDto issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {
        return transactionService.issueBook(issueBookRequestDto);
    }
    @PostMapping("return")
    public ReturnBookResponseDto returnBook(@RequestBody ReturnBookRequestDto returnBookRequestDto) throws Exception{
        return transactionService.returnBook(returnBookRequestDto);
    }
}
