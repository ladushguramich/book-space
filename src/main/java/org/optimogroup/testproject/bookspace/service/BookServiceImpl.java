package org.optimogroup.testproject.bookspace.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.optimogroup.testproject.bookspace.repositories.BookRepository;
import org.optimogroup.testproject.bookspace.DTO.BookDTO;
import org.optimogroup.testproject.bookspace.models.Book;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;


    @Override
    public Book createBook(BookDTO bookDTO) {
        Book createBook = new Book();

        createBook.setId(bookDTO.getId());
        createBook.setAuthor(bookDTO.getAuthor());
        createBook.setTitle(bookDTO.getTitle());
        createBook.setIsbn(bookDTO.getIsbn());
        createBook.setUser(bookDTO.getUser());
        createBook.setStatus(bookDTO.isStatus());

        return bookRepository.save(createBook);
    }

    @Override
    public Book updateBook(Integer id, BookDTO bookDTO) {
        Book updateBook = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book not found: " + id)
        );

        updateBook.setAuthor(bookDTO.getAuthor());
        updateBook.setTitle(bookDTO.getTitle());
        updateBook.setIsbn(bookDTO.getIsbn());
        updateBook.setUser(bookDTO.getUser());
        updateBook.setStatus(bookDTO.isStatus());

        return bookRepository.save(updateBook);
    }

    @Override
    public Book getBook(Integer id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book not found: " + id));
    }


    @Override
    public void deleteBook(Integer id) {
        if (!bookRepository.existsById(id)) {
           throw new RuntimeException("Book not found: " + id);
        } else {
            bookRepository.deleteById(id);
        }
    }
}
