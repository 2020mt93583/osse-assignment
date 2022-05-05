package com.assignment.osse.auth.api.impl;

import com.assignment.osse.auth.api.AuthResource;
import com.assignment.osse.auth.api.dto.LoginRequest;
import com.assignment.osse.auth.api.dto.SignupRequest;
import com.assignment.osse.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthResourceImpl implements AuthResource
{
    private final AuthService authService;

    @Override
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        try{
            return ResponseEntity.ok(authService.login(loginRequest));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
        }
    }

    @Override
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signup(signupRequest));
    }
}
