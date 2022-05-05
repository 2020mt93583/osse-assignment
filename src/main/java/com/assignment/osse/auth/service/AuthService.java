package com.assignment.osse.auth.service;

import com.assignment.osse.auth.api.dto.LoginRequest;
import com.assignment.osse.auth.api.dto.SignupRequest;

public interface AuthService
{
    public String login(LoginRequest loginRequest);
    public String signup(SignupRequest signupRequest);
}
