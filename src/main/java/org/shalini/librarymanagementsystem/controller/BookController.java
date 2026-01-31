package org.shalini.librarymanagementsystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.shalini.librarymanagementsystem.dto.BookDTO;
import org.shalini.librarymanagementsystem.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("{book-id}")
    public BookDTO getBookById(@PathVariable("book-id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping()
    public boolean addBook(@Valid @RequestBody BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @PutMapping()
    public boolean updateBook(@Valid @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(bookDTO);
    }

    @DeleteMapping("{book-id}")
    public boolean deleteBook(@PathVariable("book-id") int id) {
        return bookService.deleteBook(id);
    }

}
