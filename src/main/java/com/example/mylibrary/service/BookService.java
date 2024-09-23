package com.example.mylibrary.service;

import com.example.mylibrary.DTO.RequestDto.BookRequestDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllBookResponseDto;
import com.example.mylibrary.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    //public String addBook(Book Book) throws Exception;
    public String addBook(BookRequestDto bookRequestDto) throws Exception;
    public List<GetAllBookResponseDto> getAllBooks();
}
