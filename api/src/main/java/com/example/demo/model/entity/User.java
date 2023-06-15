package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;


    // ******************************************************************

    // Ao invés de um tipo de produto, fizemos um "tipo" de usuário (role)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_role_id"))
    private UserRole userRole; // falta criar

    // ******************************************************************

    // verificar se tá certo (dúvida anterior)
    public User(String name, String password, UserRole userRole) {
        this.name = name;
        this.password = password;
        this.userRole = userRole;
    }
}
