package com.example.mylibrary.service.impl;

import com.example.mylibrary.DTO.ResponsDto.GetAllBookResponseDto;
import com.example.mylibrary.entity.Author;
import com.example.mylibrary.entity.Book;
import com.example.mylibrary.repository.AuthorRepository;
import com.example.mylibrary.repository.BookRepository;
import com.example.mylibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;


    @Override
    public String addBook(Book book) throws Exception {
        Author author;
        try{
            author = authorRepository.findById(book.getAuthor().getId()).get();

        }catch(Exception e){
           throw new Exception("Author is not present ");
        }
        author.getBooks().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "book Added !";

    }

//    @Override
//    public ResponseEntity<List<GetAllBookResponseDto>> getAllBooks() {
//        List<Book> books =   BookRepository().findAll();
//        return books.stream()
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
//    }
//    private GetAllBookResponseDto convertToDto(Book book){
//        return new GetAllBookResponseDto(book.getId(), book.getTitle(),book.getGenre(), book.getNoOfPage(), book.getPrice());
//;    }


}
