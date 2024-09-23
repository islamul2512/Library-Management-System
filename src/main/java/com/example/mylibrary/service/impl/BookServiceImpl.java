package com.example.mylibrary.service.impl;

import com.example.mylibrary.DTO.RequestDto.BookRequestDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllBookResponseDto;
import com.example.mylibrary.entity.Author;
import com.example.mylibrary.entity.Book;
import com.example.mylibrary.entity.Student;
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


//    @Override
//    public String addBook(Book book) throws Exception {
//        Author author;
//        try{
//            author = authorRepository.findById(book.getAuthor().getId()).get();
//
//        }catch(Exception e){
//           throw new Exception("Author is not present ");
//        }
//        author.getBooks().add(book);
//        book.setAuthor(author);
//
//        authorRepository.save(author);
//        return "book Added !";
//
//    }

    @Override
    public String addBook(BookRequestDto bookRequestDto) throws Exception {
        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setNoOfPage(bookRequestDto.getNoOfPage());
        book.setPrice(bookRequestDto.getPrice());

        // Find the Author by the provided ID or throw an exception if not present
        Author author = authorRepository.findById(bookRequestDto.getAuthorId())
                .orElseThrow(() -> new Exception("Author is not present"));

        // Add the book to the author's list of books
        author.getBooks().add(book);

        // Set the author in the book entity
        book.setAuthor(author);

        // Save the author, which will also save the new book (due to cascading)
        authorRepository.save(author);

        return "Book added!";
    }

    @Override
    public List<GetAllBookResponseDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        // convert entities to dto
        return books.stream().map(this::convert).collect(Collectors.toList());
    }
    private GetAllBookResponseDto convert(Book book){
        return new GetAllBookResponseDto(book.getId(), book.getTitle(),book.getGenre(),book.getNoOfPage(), book.getPrice());
    }



}
