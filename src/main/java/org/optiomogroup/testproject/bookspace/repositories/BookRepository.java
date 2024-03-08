package org.optiomogroup.testproject.bookspace.repositories;

import org.optiomogroup.testproject.bookspace.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
