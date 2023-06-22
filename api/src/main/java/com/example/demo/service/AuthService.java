package com.example.demo.service;

import com.example.demo.model.dto.request.AuthLoginDTO;
import com.example.demo.model.dto.request.AuthRegisterDTO;
import com.example.demo.model.dto.response.AuthenticationResponse;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String CPF) throws UsernameNotFoundException {
        return userRepository.findByCPF(CPF).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public AuthenticationResponse register(AuthRegisterDTO request) {
        User userToRegister = request.toUser();
        userToRegister.setPassword(passwordEncoder.encode(userToRegister.getPassword()));
        userRepository.save(userToRegister);
        return new AuthenticationResponse(jwtService.generateToken(userToRegister));
    }

    public AuthenticationResponse authenticate(AuthLoginDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getCPF(),
                        request.getPassword()
                )
        );
        User userToAuthenticate = userRepository.findByCPF(request.getCPF()).get();
        return new AuthenticationResponse(jwtService.generateToken(userToAuthenticate));
    }
}
