package com.example.demo.repository;

import com.example.demo.model.entity.Sales;
import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findBySalesPerson(User salesPerson);
}
