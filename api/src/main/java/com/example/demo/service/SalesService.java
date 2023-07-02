package com.example.demo.service;

import com.example.demo.model.dto.request.SalesCreationRequestDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.Sales;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SalesRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public void create(SalesCreationRequestDTO request){

        Sales sale = request.toEntity();
        sale.setSalesPerson(userRepository.findById(request.getSalesPersonId()).get());

        List<Product> productList = request.getProductList().stream()
                .map(productId -> productRepository.findById(productId).get())
                .toList();

        sale.setListProducts(productList);

        salesRepository.save(sale);
    }
}
