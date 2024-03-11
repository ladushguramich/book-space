package org.optimogroup.testproject.bookspace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"user\"", schema = "public")
public class User {

    @Id
    @SequenceGenerator(name = "USER_ID_GENERATOR", schema = "public", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
    private Integer id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "hash")
    private String hash;

    @Column(name = "list_of_books_taken")
    private Integer listOfBooksTaken;
}
