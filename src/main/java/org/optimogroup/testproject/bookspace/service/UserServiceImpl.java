package org.optimogroup.testproject.bookspace.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.List;
import org.optimogroup.testproject.bookspace.DTO.UserDTO;
import org.optimogroup.testproject.bookspace.models.Book;
import org.optimogroup.testproject.bookspace.models.User;
import org.optimogroup.testproject.bookspace.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(UserDTO userDTO) {
        User createUser = new User();

        createUser.setId(userDTO.getId());
        createUser.setFirstName(userDTO.getFirstName());
        createUser.setLastName(userDTO.getLastName());
        createUser.setPhone(userDTO.getPhone());
        createUser.setHash(userDTO.getHash());
//        createUser.setListOfBooksTaken(userDTO.getListOfBooksTaken());
//        User savedUser = userRepository.save(createUser);
//        System.out.println(savedUser);
        return userRepository.save(createUser);
    }

    @Override
    public User updateUser(Integer id, UserDTO userDTO) {
        User updateUser = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found: " + id)
        );
        updateUser.setFirstName(userDTO.getFirstName());
        updateUser.setLastName(userDTO.getLastName());
        updateUser.setPhone(userDTO.getPhone());
        updateUser.setHash(userDTO.getHash());
//        updateUser.setListOfBooksTaken(userDTO.getListOfBooksTaken());

        return userRepository.save(updateUser);
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found: " + id)
        );
    }

    @Override
    public void DeleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found: " + id);
        } else {
            userRepository.deleteById(id);
        }
    }
}
