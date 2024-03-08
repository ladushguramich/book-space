package org.optiomogroup.testproject.bookspace.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private BigInteger id;
    private String first_nanme;
    private String last_name;
    private String phone;
    private String hash;
    private BigInteger list_of_books_taken;
}
