package com.example.demo.controller;

import com.example.demo.model.dto.request.SalesCreationRequestDTO;
import com.example.demo.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


}
