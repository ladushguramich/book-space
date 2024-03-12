package org.optimogroup.testproject.bookspace.repositories;

import org.optimogroup.testproject.bookspace.models.Book;
import org.optimogroup.testproject.bookspace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
