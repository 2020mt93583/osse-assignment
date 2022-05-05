package com.assignment.osse.auth.api;

import com.assignment.osse.auth.api.dto.LoginRequest;
import com.assignment.osse.auth.api.dto.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface AuthResource
{

    public ResponseEntity login(LoginRequest loginRequest);
    public ResponseEntity signup(SignupRequest signupRequest);
}
