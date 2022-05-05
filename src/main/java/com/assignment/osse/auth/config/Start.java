package com.assignment.osse.auth.config;

import com.assignment.osse.auth.repo.UserRepository;
import com.assignment.osse.auth.repo.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Configuration
@AllArgsConstructor
@Slf4j
public class Start
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    private void init() {
        if (userRepository.findAll()
                          .isEmpty())
        {
            userRepository.save(User.builder()
                                    .created(Instant.now())
                                    .email("x@y.com")
                                    .enabled(true)
                                    .password(passwordEncoder.encode(
                                            "testPass123"))
                                    .username("testUser")
                                    .build());
        }
    }
}
