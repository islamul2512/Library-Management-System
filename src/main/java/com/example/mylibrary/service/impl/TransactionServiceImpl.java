package com.example.mylibrary.service.impl;

import com.example.mylibrary.DTO.RequestDto.IssueBookRequestDto;
import com.example.mylibrary.DTO.RequestDto.ReturnBookRequestDto;
import com.example.mylibrary.DTO.ResponsDto.IssueBookResponseDto;
import com.example.mylibrary.DTO.ResponsDto.ReturnBookResponseDto;
import com.example.mylibrary.entity.Book;
import com.example.mylibrary.entity.Card;
import com.example.mylibrary.entity.Transaction;
import com.example.mylibrary.enums.CardStatus;
import com.example.mylibrary.enums.TransactionStatus;
import com.example.mylibrary.repository.BookRepository;
import com.example.mylibrary.repository.CardRepository;
import com.example.mylibrary.repository.TransactionRepository;
import com.example.mylibrary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private JavaMailSender emailSender;
    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        Card card;
        try{
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id!!!");
        }

        transaction.setCard(card);

        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book id!!!!");
        }

        transaction.setBook(book);

        if(card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not Active!!!");
        }

        if(book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available!!!");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getBooksIssued().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card); // save card, book and transaction.





        String text = "Congrats! " + card.getStudent().getName() +  " You have been issued the book " + book.getTitle();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("manuuspring@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Issue book");
        message.setText(text);
        emailSender.send(message);

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        //issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());

        return issueBookResponseDto;

    }

    @Override
    public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(false); // Set operation as return

        Card card;
        try {
            card = cardRepository.findById(returnBookRequestDto.getCardId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Card Id !!");
        }

        transaction.setCard(card);

        Book book;
        try {
            book = bookRepository.findById(returnBookRequestDto.getBookId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book id!!!!");
        }

        transaction.setBook(book);

        if (card.getCardStatus() != CardStatus.ACTIVATED) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not Active!!!");
        }

        if (!book.isIssued() || !book.getCard().equals(card)) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book was not issued to this card!!!");
        }

        // Update transaction and book status
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(false);
        book.setCard(null);
        book.getTransactionList().add(transaction);

        card.getBooksIssued().remove(book);
        card.getTransactionList().add(transaction);

        // Save the changes
        cardRepository.save(card); // Save the card, which also saves the book and transaction updates

        // Send email notification
        String text = "You have successfully returned the book: " + book.getTitle();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("manuuspring@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Return book");
        message.setText(text);
        emailSender.send(message);

        // Prepare response DTO
        ReturnBookResponseDto returnBookResponseDto = new ReturnBookResponseDto();
        returnBookResponseDto.setBookName(book.getTitle());
        returnBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());

        return returnBookResponseDto;
    }
}
