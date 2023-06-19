package com.example.demo.service;

import com.example.demo.model.dto.request.ProductCreationRequestDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    public void create(ProductCreationRequestDTO request){
        Product productToSave = request.toEntity();

        productToSave.setProductType(productTypeRepository.findByName(request.getProductType()).get());

        productRepository.save(productToSave);
    }
}
