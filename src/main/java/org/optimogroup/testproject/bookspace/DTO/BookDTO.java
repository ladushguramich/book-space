package org.optimogroup.testproject.bookspace.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String author;
    private String title;
    private String isbn;
    private Integer user;
    private boolean status;
}
