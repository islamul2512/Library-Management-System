package com.example.mylibrary.controller;

import com.example.mylibrary.DTO.RequestDto.AuthorRequestDto;
import com.example.mylibrary.DTO.ResponsDto.AuthorResponseDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllAuthorResponseDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllStudentResponseDto;
import com.example.mylibrary.entity.Author;
import com.example.mylibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
//    @PostMapping("add")
//    public String addAuthor(@RequestBody Author author){
//        return authorService.addAuthor(author);
//    }
    @PostMapping("add")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto){

        return authorService.addAuthor(authorRequestDto);
    }

    @GetMapping("/get_by_email")
    public AuthorResponseDto getAuthorByEmail(@RequestParam("email") String email){

        return authorService.getByEmail(email);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GetAllAuthorResponseDto>> getAllAuthors() {
        // The service should return a list directly.
        List<GetAllAuthorResponseDto> authors =  authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }



    // delete a student by id

    // update the student by id

    // find a student by id

    // find all the students

    // get all the authors of a particular age
}
