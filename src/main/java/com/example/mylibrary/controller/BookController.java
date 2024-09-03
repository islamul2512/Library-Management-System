package com.example.mylibrary.controller;

import com.example.mylibrary.DTO.ResponsDto.GetAllBookResponseDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllStudentResponseDto;
import com.example.mylibrary.entity.Book;
import com.example.mylibrary.service.AuthorService;
import com.example.mylibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception{
        return bookService.addBook(book);
    }

    // find all the books

//    @GetMapping("/all")
//    public ResponseEntity<List<GetAllBookResponseDto>> getAllBooks() {
//        List<GetAllStudentResponseDto> books = bookService.getAllStudents();
//        return ResponseEntity.ok(books);
//    }


    // find all the books of a particular authorId



    // // find the number of books written by an author
}
