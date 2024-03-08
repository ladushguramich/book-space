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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", schema = "public")
public class User {

    @Id
    private BigInteger id;

    @Column(name = "first_nanme")
    public String first_nanme;

    @Column(name = "last_name")
    public String last_name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "hash")
    private String hash;

    @Column(name = "list_of_books_taken")
    private BigInteger list_of_books_taken;
}
