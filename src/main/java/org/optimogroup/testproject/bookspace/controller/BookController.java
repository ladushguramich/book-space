package org.optimogroup.testproject.bookspace.controller;

import lombok.AllArgsConstructor;
import org.optimogroup.testproject.bookspace.DTO.BookDTO;
import org.optimogroup.testproject.bookspace.models.Book;
import org.optimogroup.testproject.bookspace.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
        try {
            Book createBook = bookService.createBook(bookDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createBook);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        try {
            Book updateBook = bookService.updateBook(id, bookDTO);
            return ResponseEntity.ok(updateBook);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        try {
            Book book = bookService.getBook(id);
            if (book != null) {
                return ResponseEntity.ok(book);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        try {
                bookService.deleteBook(id);
                return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
