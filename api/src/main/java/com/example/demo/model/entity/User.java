package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "users")
// Essa classe é uma entidade que representa um usuário no banco de dados.
public class User implements UserDetails {
    // Campos:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "cpf", nullable = false, unique = true)
    private String CPF;

    @Column(name = "user_role", nullable = false)
    private String userRole;

    public User(String name, String password, String userRole, String CPF) {
        this.name = name;
        this.password = password;
        this.userRole = userRole;
        this.CPF = CPF;
    }

    // Métodos:
    // 1) Retorna uma coleção de GrantedAuthority que representa os roles do usuário
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole));
    }

    // 2) Retorna o CPF do usuário, que é usado como o nome de usuário.
    @Override
    public String getUsername() {
        return CPF;
    }

    // 3) Retorna True caso a conta passe em um dos testes de autenticação
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 4) Retorna True caso a conta passe em um dos testes de autenticação
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 5) Retorna True caso a conta passe em um dos testes de autenticação
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 6) Retorna True caso a conta passe em um dos testes de autenticação
    @Override
    public boolean isEnabled() {
        return true;
    }
}
