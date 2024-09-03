package com.example.mylibrary.service.impl;

import com.example.mylibrary.DTO.ResponsDto.AuthorResponseDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllAuthorResponseDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllStudentResponseDto;
import com.example.mylibrary.entity.Author;
import com.example.mylibrary.entity.Student;
import com.example.mylibrary.repository.AuthorRepository;
import com.example.mylibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author) {
         authorRepository.save(author);
         return "Author added !";
    }

    @Override
    public AuthorResponseDto getByEmail(String email) {
        Author author = authorRepository.findByEmail(email);


        // prepare response Dto
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());


        return authorResponseDto;
    }

//    @Override
//    public ResponseEntity<List<GetAllAuthorResponseDto>> getAllAuthors() {
//        List<Author> authors = authorRepository.findAll();
//
//        // Convert entities to response DTOs
//        List<GetAllAuthorResponseDto> authorDtos = authors.stream()
//                .map(this::convertToResponseDto)
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(authorDtos);
//    }
//    private GetAllAuthorResponseDto convertToResponseDto(Author author) {
//        return new GetAllAuthorResponseDto(author.getId(),author.getName(),author.getAge(),author.getEmail());
//
//    }
//

}
