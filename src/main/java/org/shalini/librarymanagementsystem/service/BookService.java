package org.shalini.librarymanagementsystem.service;

import org.mapstruct.factory.Mappers;
import org.shalini.librarymanagementsystem.dto.BookDTO;
import org.shalini.librarymanagementsystem.entity.Book;
import org.shalini.librarymanagementsystem.mapper.BookMapper;
import org.shalini.librarymanagementsystem.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final Logger logger = LoggerFactory.getLogger(BookService.class);
    private final BookMapper bookMapper = Mappers.getMapper(BookMapper.class);

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        for (Book book : books)
            bookDTOS.add(bookMapper.convertToBookDTO(book));
        return bookDTOS;
    }

    public BookDTO getBookById(int id) {
        return bookMapper.convertToBookDTO(bookRepository.getReferenceById(id));
    }

    public boolean addBook(BookDTO bookDTO) {
        try {
            System.out.println(bookDTO.getAuthor());
            Book book = bookMapper.convertToBook(bookDTO);
            System.out.println(book.getAuthor());

            bookRepository.save(book);
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }

    public boolean updateBook(BookDTO bookDTO) {
        try {

            //wrong implementation
            System.out.println(bookDTO.getAuthor());
            Book book = bookMapper.convertToBook(bookDTO);
            System.out.println(book.getAuthor());

            bookRepository.save(book);
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }

    public boolean deleteBook(int id) {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
