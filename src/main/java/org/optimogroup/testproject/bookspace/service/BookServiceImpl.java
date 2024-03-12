package org.optimogroup.testproject.bookspace.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.optimogroup.testproject.bookspace.models.User;
import org.optimogroup.testproject.bookspace.repositories.BookRepository;
import org.optimogroup.testproject.bookspace.DTO.BookDTO;
import org.optimogroup.testproject.bookspace.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserService userService;


    @Override
    public Book createBook(BookDTO bookDTO) {
        Book createBook = new Book();

        createBook.setId(bookDTO.getId());
        createBook.setAuthor(bookDTO.getAuthor());
        createBook.setTitle(bookDTO.getTitle());
        createBook.setIsbn(bookDTO.getIsbn());
//        createBook.setUser(bookDTO.getUser());
        createBook.setStatus(bookDTO.isStatus());

        return bookRepository.save(createBook);
    }

    @Override
    public Book updateBook(Long id, BookDTO bookDTO) {
        Book updateBook = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book not found: " + id)
        );

        updateBook.setAuthor(bookDTO.getAuthor());
        updateBook.setTitle(bookDTO.getTitle());
        updateBook.setIsbn(bookDTO.getIsbn());
//        updateBook.setUser(bookDTO.getUser());
        updateBook.setStatus(bookDTO.isStatus());

        return bookRepository.save(updateBook);
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book not found: " + id));
    }


    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found: " + id);
        } else {
            bookRepository.deleteById(id);
        }
    }

    @Override
    public Book takeBook(Long bookId, Integer userId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new RuntimeException("Book not found: " + bookId)
        );

        if (book.isStatus()) {
            throw new RuntimeException("Book is already taken");
        }

        User user = userService.getUser(userId);
        book.setUser(user);
        book.setStatus(true);

        return bookRepository.save(book);
    }

    @Override
    public Book returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new RuntimeException("Book not found: " + bookId)
        );
        if (!book.isStatus()) {
            throw new RuntimeException("Book is not taken");
        }

        book.setUser(null);
        book.setStatus(false);

        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author);
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findBooksByTitle(title);
    }

    @Override
    public List<Book> findBooksByIsbn(String isbn) {
        return bookRepository.findBooksByIsbn(isbn);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByUser(Long id) {
        try {
            List<Book> books = bookRepository.findBooksByUser(id);
            return books;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Book> findBooksByAuthorAndTitleAndIsbn(String author, String title, String isbn) {
        if (author != null && title != null && isbn != null) {
            return bookRepository.findBooksByAuthorAndTitleAndIsbn(author, title, isbn);
        } else if (author != null) {
            return bookRepository.findBooksByAuthor(author);
        } else if (title != null) {
            return bookRepository.findBooksByTitle(title);
        } else if (isbn != null) {
            return bookRepository.findBooksByIsbn(isbn);
        }
        return bookRepository.findAll();
    }
}
