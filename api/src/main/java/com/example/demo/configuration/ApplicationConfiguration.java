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

@Configuration
@RequiredArgsConstructor

/**
 * Configuração do provedor de serviços de autenticação do Spring (UserDetailsService e AuthenticationProvider) e do AuthenticationManager.
 */
public class ApplicationConfiguration {

    private final UserRepository userRepository;


    @Bean
    /** Retorna uma instância de UserDetailsService. Encontra e carrega os detalhes do usuário com base no CPF fornecido durante o processo de autenticação, caso o usuário exista. */
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByCPF(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean
    /** Cria e configura um DaoAuthenticationProvider, define o UserDetailsService personalizado e o codificador de senhas, e retorna o provedor de autenticação configurado. */
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }

    @Bean
    /** Responsável por processar as operações de autenticação no Spring Security. */
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
