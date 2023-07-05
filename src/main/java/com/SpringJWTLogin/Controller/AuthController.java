package com.SpringJWTLogin.Controller;

import com.SpringJWTLogin.Model.JWTAuthResponse;
import com.SpringJWTLogin.Model.LoginDto;
import com.SpringJWTLogin.Model.User;
import com.SpringJWTLogin.Repository.UserRepository;
import com.SpringJWTLogin.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    private AuthService authService;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody  LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }


    @GetMapping("/user")
    public Optional<User> getUser(@RequestParam User name){
        return userRepository.findByUsername(String.valueOf(name));
    }
}
