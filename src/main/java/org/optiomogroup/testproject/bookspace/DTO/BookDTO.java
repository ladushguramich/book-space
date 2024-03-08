package org.optiomogroup.testproject.bookspace.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private BigInteger id;
    private String authot;
    private String title;
    private String isbn;
    private BigInteger user;
    private boolean status;
}
