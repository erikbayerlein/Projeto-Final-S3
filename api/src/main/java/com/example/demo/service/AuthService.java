package com.example.demo.service;

import com.example.demo.model.dto.request.AuthLoginDTO;
import com.example.demo.model.dto.request.AuthRegisterDTO;
import com.example.demo.model.dto.response.AuthenticationResponse;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
// 
public class AuthService implements UserDetailsService {
    // Campos:
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    // Métodos:
    // 1) Consulta o UserRepository para encontrar o usuário com o CPF correspondente e retorna um objeto UserDetails, caso seja encontrado
    @Override
    public UserDetails loadUserByUsername(String CPF) throws UsernameNotFoundException {
        return userRepository.findByCPF(CPF).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    // 2) Realiza o registro de um novo usuário. Verifica se a senha e a confirmação de senha são iguais e, em seguida, codifica a senha antes de salvar o usuário no banco de dados. Em seguida, ele gera um token JWT para o usuário registrado e retorna um objeto AuthenticationResponse contendo o token.
    public AuthenticationResponse register(AuthRegisterDTO request) {
        User userToRegister = request.toUser();
        if(!Objects.equals(request.getPassword(), request.getConfirmPassword())) {
            throw new RuntimeException("Password and Confirm Password must be equals");
        }
        userToRegister.setPassword(passwordEncoder.encode(userToRegister.getPassword()));
        userRepository.save(userToRegister);
        return new AuthenticationResponse(jwtService.generateToken(userToRegister));
    }

    // 3) Realiza a autenticação das credenciais fornecidas no objeto AuthLoginDTO. Depois gera um token para o usuário autenticado.
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
