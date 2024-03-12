package org.optimogroup.testproject.bookspace.service;

import org.optimogroup.testproject.bookspace.DTO.BookDTO;
import org.optimogroup.testproject.bookspace.models.Book;

import java.util.List;

public interface BookService {

    Book createBook(BookDTO bookDTO);

    Book updateBook(Long id, BookDTO bookDTO);

    Book getBook(Long id);

    void deleteBook(Long id);

    Book takeBook(Long bookId, Integer userId);

    Book returnBook(Long id);
    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByIsbn(String isbn);
    List<Book> findAllBooks();
    List<Book> getBooksByUser(Long id);
    List<Book> findBooksByAuthorAndTitleAndIsbn(String author, String title, String isbn);
}
