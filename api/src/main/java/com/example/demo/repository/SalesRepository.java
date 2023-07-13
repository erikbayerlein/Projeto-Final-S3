package com.example.demo.repository;

import com.example.demo.model.entity.Sales;
import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
// Essa interface define operações de acesso a dados relacionadas à entidade Sales
public interface SalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findBySalesPerson(User salesPerson);

    List<Sales> findAllByClient(User client);

    List<Sales> findAllByDate(LocalDate date);
}
