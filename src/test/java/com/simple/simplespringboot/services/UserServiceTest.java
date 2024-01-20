package com.simple.simplespringboot.services;

import com.simple.simplespringboot.model.User;
import com.simple.simplespringboot.model.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Get all users")
    void getAll() {
        var expectedUsers = Collections.singletonList(new User(1L, "John Doe"));
        when(userRepository.findAll()).thenReturn(expectedUsers);
        var actualUsers = userService.getAll();
        assertThat(actualUsers).isEqualTo(expectedUsers);
        verify(userRepository, atLeastOnce()).findAll();
    }

    @Test
    @DisplayName("Save user")
    void save() {
        var expectedUser = new User(1L, "John Doe");
        when(userRepository.save(expectedUser)).thenReturn(expectedUser);
        var actualUser = userService.save(expectedUser);
        assertThat(actualUser).isEqualTo(expectedUser);
        verify(userRepository, atLeastOnce()).save(expectedUser);
    }

    @DisplayName("Delete user")
    @Test
    void delete() {
        var id = 1L;
        doNothing().when(userRepository).deleteById(id);
        userService.delete(id);
        verify(userRepository, atLeastOnce()).deleteById(id);
    }
}