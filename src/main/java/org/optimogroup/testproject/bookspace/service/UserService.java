package org.optimogroup.testproject.bookspace.service;

import org.hibernate.mapping.List;
import org.optimogroup.testproject.bookspace.DTO.UserDTO;
import org.optimogroup.testproject.bookspace.models.Book;
import org.optimogroup.testproject.bookspace.models.User;

public interface UserService {

    User createUser(UserDTO userDTO);

    User updateUser(Integer id, UserDTO userDTO);

    User getUser(Integer id);

    void DeleteUser(Integer id);

}
