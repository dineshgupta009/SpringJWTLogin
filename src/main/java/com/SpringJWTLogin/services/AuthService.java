package com.SpringJWTLogin.services;

import com.SpringJWTLogin.Model.LoginDto;
import lombok.Data;

public interface AuthService {

    String login(LoginDto loginDto);
}
