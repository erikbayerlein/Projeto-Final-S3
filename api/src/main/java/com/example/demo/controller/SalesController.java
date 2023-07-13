package com.example.demo.controller;

import com.example.demo.model.dto.request.ListSalesByDateRequestDTO;
import com.example.demo.model.dto.request.SalesCreationRequestDTO;
import com.example.demo.model.entity.Sales;
import com.example.demo.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin
@RequiredArgsConstructor

// Essa classe define as rotas para criação, busca e manipulação de vendas.
public class SalesController {

    // Campos:
    private final SalesService salesService;

    // Métodos:
    // 1) Endpoint que lida com a solicitação de criação de uma nova venda.
    @PostMapping("/create")
    public ResponseEntity<String> create(@Validated @RequestBody SalesCreationRequestDTO request) {
        salesService.create(request);
        return ResponseEntity.ok("Venda criada com sucesso.");
    }

    // 2) Endpoint que lida com a solicitação de busca de vendas por ID do vendedor.
    @GetMapping("/getSalesPerson/{salesPersonId}")
    public ResponseEntity<List<Sales>> findBySalesPerson(@PathVariable Long salesPersonId) {
        return ResponseEntity.ok(salesService.getBySalesPerson(salesPersonId));
    }

    // 3) Endpoint que lida com a solicitação de busca de todas as vendas.
    @GetMapping("/getAll")
    public ResponseEntity<List<Sales>> getAll() {
        return ResponseEntity.ok(salesService.getAll());
    }

    // 4) Endpoint que lida com a solicitação de busca de uma venda por ID. 
    @GetMapping("/getById/{id}")
    public ResponseEntity<Sales> getById(@PathVariable Long id) {
        return ResponseEntity.ok(salesService.getById(id));
    }

    // 5) Endpoint é um ponto de extremidade que lida com a solicitação de busca de vendas por data.
    @GetMapping("/getByDate")
    public ResponseEntity<List<Sales>> getByDate(@RequestBody ListSalesByDateRequestDTO date) {
        return ResponseEntity.ok(salesService.getByDate(date.getDate()));
    }

}
