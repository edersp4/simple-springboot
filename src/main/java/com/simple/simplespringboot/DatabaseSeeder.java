package com.simple.simplespringboot;

import com.simple.simplespringboot.model.User;
import com.simple.simplespringboot.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.save(new User(1L, "John Doe"));
        this.userRepository.save(new User(2L, "Jane Doe"));
        this.userRepository.save(new User(3L, "Foo Bar"));
    }
}

