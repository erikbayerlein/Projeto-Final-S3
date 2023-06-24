package com.example.demo.service;

import com.example.demo.model.dto.request.ProductCreationRequestDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductType;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductTypeRepository productTypeRepository;

    public void create(ProductCreationRequestDTO request){
        Product productToSave = request.toEntity(); //transforma o DTO em um produto

        if(productRepository.findProductByName(productToSave.getName()).isPresent()){ //verifica se já não existe um produto com o mesmo nome
            throw new RuntimeException("Product already exists");
        }

        ProductType productType = productTypeRepository.findByName(request.getProductType()).orElseThrow(); //verifica se o tipo de produto existe

        productToSave.setProductType(productType);

        productRepository.save(productToSave);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
