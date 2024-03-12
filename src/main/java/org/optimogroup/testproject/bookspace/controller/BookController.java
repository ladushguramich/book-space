package org.optimogroup.testproject.bookspace.controller;

import lombok.AllArgsConstructor;
import org.optimogroup.testproject.bookspace.DTO.BookDTO;
import org.optimogroup.testproject.bookspace.models.Book;
import org.optimogroup.testproject.bookspace.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        try {
            Book updateBook = bookService.updateBook(id, bookDTO);
            return ResponseEntity.ok(updateBook);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
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
    public ResponseEntity deleteById(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/take/{bookId}/{userId}")
    public ResponseEntity<String> takeBook(@PathVariable Long bookId, @PathVariable Integer userId) {
        try {
            bookService.takeBook(bookId, userId);
            return ResponseEntity.ok("Book taken successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/return/{bookId}/{userId}")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId) {
        try {
            bookService.returnBook(bookId);
            return ResponseEntity.ok("Book returned successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> findBooksByParams(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String isbn
    ) {
        try {
            List<Book> foundBooks;

            if (author != null) {
                foundBooks = bookService.findBooksByAuthor(author);
            } else if (title != null) {
                foundBooks = bookService.findBooksByTitle(title);
            } else if (isbn != null) {
                foundBooks = bookService.findBooksByIsbn(isbn);
            } else {
                foundBooks = bookService.findAllBooks();
            }

            if (!foundBooks.isEmpty()) {
                return ResponseEntity.ok(foundBooks);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}