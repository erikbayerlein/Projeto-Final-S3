package com.example.demo.service;

import com.example.demo.model.dto.request.AuthLoginDTO;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    public void login(AuthLoginDTO request){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getCPF(), request.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(token);

        User user = (User) authentication.getPrincipal();



    }

    @Override
    public UserDetails loadUserByUsername(String CPF) throws UsernameNotFoundException {
        return userRepository.findByCPF(CPF).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
