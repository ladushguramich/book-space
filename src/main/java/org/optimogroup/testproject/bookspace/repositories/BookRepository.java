package org.optimogroup.testproject.bookspace.repositories;

import org.optimogroup.testproject.bookspace.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByAuthorAndTitleAndIsbn(String author, String title, String isbn);

    List<Book> findBooksByAuthor(String author);

    List<Book> findBooksByTitle(String title);

    List<Book> findBooksByIsbn(String isbn);

    @Query("SELECT b FROM Book b JOIN b.user u WHERE u.id = ?1")
    List<Book> findBooksByUser(Long id);
}
