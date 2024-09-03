package com.example.mylibrary.service;

import com.example.mylibrary.DTO.ResponsDto.AuthorResponseDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllAuthorResponseDto;
import com.example.mylibrary.entity.Author;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorService {
    public String addAuthor(Author author);
    public AuthorResponseDto getByEmail(String email);
//    public ResponseEntity<List<GetAllAuthorResponseDto>> getAllAuthors();
}
