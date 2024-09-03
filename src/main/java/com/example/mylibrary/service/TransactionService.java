package com.example.mylibrary.service;

import com.example.mylibrary.DTO.RequestDto.IssueBookRequestDto;
import com.example.mylibrary.DTO.RequestDto.ReturnBookRequestDto;
import com.example.mylibrary.DTO.ResponsDto.IssueBookResponseDto;
import com.example.mylibrary.DTO.ResponsDto.ReturnBookResponseDto;

public interface TransactionService {
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
    public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto ) throws Exception;
}
