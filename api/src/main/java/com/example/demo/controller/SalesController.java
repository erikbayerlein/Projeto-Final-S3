package com.example.demo.controller;

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
public class SalesController {
    private final SalesService salesService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@Validated @RequestBody SalesCreationRequestDTO request) {
        salesService.create(request);
        return ResponseEntity.ok("Venda criada com sucesso.");
    }

    @GetMapping("/getSalesPerson/{salesPersonId}")
    public ResponseEntity<List<Sales>> findBySalesPerson(@PathVariable Long salesPersonId) {
        return ResponseEntity.ok(salesService.getBySalesPerson(salesPersonId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Sales>> getAll() {
        return ResponseEntity.ok(salesService.getAll());
    }

}
