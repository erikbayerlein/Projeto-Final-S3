package com.example.demo.repository;

import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// Essa interface define operações de acesso a dados relacionadas à entidade User
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCPF(String cpf);
}
