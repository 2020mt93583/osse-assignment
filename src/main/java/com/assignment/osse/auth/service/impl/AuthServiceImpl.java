package com.assignment.osse.auth.service.impl;

import com.assignment.osse.auth.api.dto.LoginRequest;
import com.assignment.osse.auth.api.dto.SignupRequest;
import com.assignment.osse.auth.repo.UserRepository;
import com.assignment.osse.auth.repo.entity.User;
import com.assignment.osse.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @SneakyThrows
    public String login(LoginRequest loginRequest) {
        User user = userRepository.findUserByUsername(loginRequest.getUsername());
        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
        {
            return UUID.randomUUID()
                       .toString();
        }
        throw new IllegalAccessException();
    }

    @Override
    public String signup(SignupRequest signupRequest) {
        User newUser = User.builder()
                           .username(signupRequest.getUsername())
                           .password(passwordEncoder.encode(signupRequest.getPassword()))
                           .email(signupRequest.getEmail())
                           .created(Instant.now())
                           .build();

        return userRepository.save(newUser)
                             .getUserId()
                             .toString();
    }
}
