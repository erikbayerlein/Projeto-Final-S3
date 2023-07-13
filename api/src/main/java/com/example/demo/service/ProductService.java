package com.example.demo.service;

import com.example.demo.model.dto.request.ProductCreationRequestDTO;
import com.example.demo.model.dto.request.ProductTypeCreationDTO;
import com.example.demo.model.dto.request.ProductUpdateRequestDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductType;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor



/**
 *  Essa classe lida com a lógica de negócios relacionada aos produtos.
 *
 * @param Objetos do tipo ProductRepository e ProductTypeRepository
 * 
 */
public class ProductService {
    
    private final ProductRepository productRepository;

    private final ProductTypeRepository productTypeRepository;

    /** Transforma o ProductCreationRequestDTO em um produto, e verifica se é posível cadastrar o produto. */
    public void create(ProductCreationRequestDTO request){
        Product productToSave = request.toEntity(); 

        if(productRepository.findProductByName(productToSave.getName()).isPresent()){ //verifica se já não existe um produto com o mesmo nome
            throw new RuntimeException("Produto já cadastrado");
        }

        ProductType productType = productTypeRepository.findByName(request.getProductType()).orElseThrow(); //verifica se o tipo de produto existe

        productToSave.setProductType(productType);

        productRepository.save(productToSave);
    }

    /** Recebe o ID do produto como parâmetro e atualiza o produto existente */
    public void update(ProductUpdateRequestDTO request, Long id){
        Product productToSave = request.toEntity();

        ProductType productType = productTypeRepository.findByName(request.getProductType()).orElseThrow(); 

        productToSave.setProductType(productType);

        productRepository.save(productToSave);
    }

    /**  Transforma o ProductTypeCreationRequestDTO em um tipo de produto, e verifica se é posível cadastrar o novo tipo de produto. */
    public void createProductType(ProductTypeCreationDTO request){
        ProductType productType = request.toEntity();
        if(productTypeRepository.findByName(productType.getName()).isPresent()){
            throw new RuntimeException("Tipo de produto já cadastrado");
        }
        productTypeRepository.save(productType);
    }

    /** Recupera um produto do banco de dados com base no ID fornecido */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    /** Recupera todos os produtos do banco de dados usando o método findAll do productRepository */
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()){
            throw new RuntimeException("Não há produtos cadastrados");
        }
        return products;
    }
}
