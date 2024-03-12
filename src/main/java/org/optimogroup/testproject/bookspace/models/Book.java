package org.optimogroup.testproject.bookspace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book", schema = "public")
public class Book {

    @Id
    @SequenceGenerator(name = "BOOK_ID_GENERATOR", schema = "public", sequenceName = "book_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_ID_GENERATOR")
    private Long id;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "\"user\"")
    private User user;

    @Column(name = "status")
    private boolean status;

}
