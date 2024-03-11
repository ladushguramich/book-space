package org.optimogroup.testproject.bookspace.service;

import org.optimogroup.testproject.bookspace.DTO.BookDTO;
import org.optimogroup.testproject.bookspace.models.Book;

public interface BookService {

    Book createBook(BookDTO bookDTO);

    Book updateBook(Integer id, BookDTO bookDTO);

    Book getBook(Integer id);

    void deleteBook(Integer id);
}
