package com.example.demo.configuration;

import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Essa é uma classe de configuração.
@Configuration
@RequiredArgsConstructor

//Essa classe de configuração está configurando o provedor de serviços de autenticação do Spring (UserDetailsService e AuthenticationProvider) e também está configurando o AuthenticationManager. Essas configurações são essenciais para a autenticação e autorização na aplicação Spring Boot.
public class ApplicationConfiguration {

    // Campos: 
    private final UserRepository userRepository;

    // Métodos:
    // 1) Retorna uma instância de UserDetailsService. Encontra e carrega os detalhes do usuário com base no CPF fornecido durante o processo de autenticação, caso o usuário exista.
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByCPF(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    // 2) Cria e configura um DaoAuthenticationProvider, define o UserDetailsService personalizado e o codificador de senhas, e retorna o provedor de autenticação configurado.
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }

    // 3) Responsável por processar as operações de autenticação no Spring Security.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
