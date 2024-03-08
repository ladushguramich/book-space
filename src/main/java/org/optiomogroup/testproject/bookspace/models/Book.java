package org.optiomogroup.testproject.bookspace.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book", schema = "public")
public class Book {

    @Id
    private BigInteger id;

    @Column(name = "authot")
    private String authot;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "user")
    private BigInteger user;

    @Column(name = "status")
    private boolean status;

}
