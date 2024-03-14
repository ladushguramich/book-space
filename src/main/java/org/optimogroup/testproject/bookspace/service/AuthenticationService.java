package org.optimogroup.testproject.bookspace.service;

import lombok.RequiredArgsConstructor;
import org.optimogroup.testproject.bookspace.authController.AuthenticationRequest;
import org.optimogroup.testproject.bookspace.authController.AuthenticationResponse;
import org.optimogroup.testproject.bookspace.authController.RegisterRequest;
import org.optimogroup.testproject.bookspace.config.JwtService;
import org.optimogroup.testproject.bookspace.models.Role;
import org.optimogroup.testproject.bookspace.models.User;
import org.optimogroup.testproject.bookspace.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authentication(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getPhone(), request.getHash())
        );
        var user = repository.findByPhone(request.getPhone()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .phone(request.getPhone()).hash(passwordEncoder.encode(request.getHash())).build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
