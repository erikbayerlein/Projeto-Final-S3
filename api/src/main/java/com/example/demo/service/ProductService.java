package com.example.demo.service;

import com.example.demo.model.dto.request.ProductCreationRequestDTO;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    ProductRepository productRepository;

    public void create(ProductCreationRequestDTO request){
        productRepository.save(request.toEntity());
    }
}
