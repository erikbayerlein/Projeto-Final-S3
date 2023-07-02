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
    private final UserService userService;

    public void create(SalesCreationRequestDTO request){

        Sales sale = request.toEntity();

        List<Product> productList = request.getProductList().stream()
                .map(productId -> productRepository.findById(productId).get())
                .toList();

        sale.setSalesPerson(userRepository.findById(request.getSalesPersonId()).get());
        sale.setListProducts(productList);
        sale.setClient(userService.getUser());

        salesRepository.save(sale);
    }

    public Sales getById(Long id) {
        return salesRepository.findById(id).get();
    }

    public List<Sales> getBySalesPerson(Long salesPersonId) {
        return salesRepository.findBySalesPerson(userRepository.findById(salesPersonId).get());
    }

}
