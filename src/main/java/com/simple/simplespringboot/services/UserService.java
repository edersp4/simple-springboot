package com.simple.simplespringboot.services;

import com.simple.simplespringboot.model.User;
import com.simple.simplespringboot.model.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAll() {
        log.debug("Getting all users");
        return userRepository.findAll();
    }

    public User save(User user) {
        log.debug("Saving user: {}", user);
        return userRepository.save(user);
    }

    public void delete(Long id) {
        log.debug("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }
}
