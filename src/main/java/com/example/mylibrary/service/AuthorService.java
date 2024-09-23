package com.example.mylibrary.service;

import com.example.mylibrary.DTO.RequestDto.AuthorRequestDto;
import com.example.mylibrary.DTO.ResponsDto.AuthorResponseDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllAuthorResponseDto;
import com.example.mylibrary.entity.Author;

import java.util.List;

public interface AuthorService {
    //public String addAuthor(Author author);
    public String addAuthor(AuthorRequestDto authorRequestDto);

    public AuthorResponseDto getByEmail(String email);
    public List<GetAllAuthorResponseDto> getAllAuthors();
}
