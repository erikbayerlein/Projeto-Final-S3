package com.example.demo.service;

import com.example.demo.model.dto.request.ProductCreationRequestDTO;
import com.example.demo.model.dto.request.ProductTypeCreationDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductType;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductTypeRepository productTypeRepository;

    public void create(ProductCreationRequestDTO request){
        Product productToSave = request.toEntity(); //transforma o DTO em um produto

        if(productRepository.findProductByName(productToSave.getName()).isPresent()){ //verifica se já não existe um produto com o mesmo nome
            throw new RuntimeException("Produto já cadastrado");
        }

        ProductType productType = productTypeRepository.findByName(request.getProductType()).orElseThrow(); //verifica se o tipo de produto existe

        productToSave.setProductType(productType);

        productRepository.save(productToSave);
    }

    public void createProductType(ProductTypeCreationDTO request){
        ProductType productType = request.toEntity();
        if(productTypeRepository.findByName(productType.getName()).isPresent()){
            throw new RuntimeException("Tipo de produto já cadastrado");
        }
        productTypeRepository.save(productType);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()){
            throw new RuntimeException("Não há produtos cadastrados");
        }
        return products;
    }
}
