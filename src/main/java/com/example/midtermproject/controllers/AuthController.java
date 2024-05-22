package com.example.midtermproject.controllers;


import com.example.midtermproject.dto.AuthLoginDTO;
import com.example.midtermproject.dto.CustomUserDetails;
import com.example.midtermproject.dto.JwtTokenDTO;
import com.example.midtermproject.dto.UserDTO;
import com.example.midtermproject.services.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("login")
    public JwtTokenDTO login(@RequestBody AuthLoginDTO loginDto){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

        if (authenticate.isAuthenticated()){
            String token = jwtService.GenerateToken(loginDto.getUsername());
            return new JwtTokenDTO(token);
        }
        throw new BadCredentialsException("Invalid username or password");
    }

    @GetMapping
    public Object getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails userDetail) {
            return new UserDTO(userDetail.user());
        }
        return principal;
    }
}