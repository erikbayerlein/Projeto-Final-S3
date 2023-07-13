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

/**
 * Uma entidade que representa um usuário no banco de dados.
 */
public class User implements UserDetails {

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

    @Override
    /** Retorna uma coleção de GrantedAuthority que representa os roles do usuário. */
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole));
    }

    @Override
    /** Retorna o CPF do usuário, que é usado como o nome de usuário. */
    public String getUsername() {
        return CPF;
    }

    @Override
    /** Retorna True caso a conta passe em um dos testes de autenticação */
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    /** Retorna True caso a conta passe em um dos testes de autenticação */
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    /** Retorna True caso a conta passe em um dos testes de autenticação */
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    /** Retorna True caso a conta passe em um dos testes de autenticação */
    public boolean isEnabled() {
        return true;
    }
}
