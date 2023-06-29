package com.example.demo.repository;

import com.example.demo.model.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    Optional<Sales> findById(Long aLong);
}
