package com.example.demo.service;

import com.example.demo.model.dto.request.ProductCreationRequestDTO;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    ProductRepository productRepository;

    public void create(ProductCreationRequestDTO request){
        // ProductRepository possui um método chamado save, o qual salva a informação no banco de dados
        // Assim, passamos o request (DTO) utilizando o seu método toEntity, o qual transforma as informações em campos de produto
        // -> arquivo request/ProductCreationRequestDTO.java
        productRepository.save(request.toEntity());
    }
}
