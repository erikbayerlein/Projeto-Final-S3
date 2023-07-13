package com.example.demo.service;

import com.example.demo.model.dto.request.SalesCreationRequestDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.Sales;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SalesRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
 
/**
 *  Essa classe lida com a lógica de negócios relacionada às vendas.
 *
 * @param Objetos do tipo SalesRepository, UserRepository, ProductRepository, UserService
 * @return Objetos do tipo Vendas e Lista de Vendas
 */
public class SalesService {

    private final SalesRepository salesRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final UserService userService;

    /** criar uma nova venda com base nos dados fornecidos no objeto request do tipo SalesCreationRequestDTO. Ele define o vendedor, a lista de produtos, o cliente (obtido do userService), a data atual e o preço total da venda. */
    public void create(SalesCreationRequestDTO request){

        Sales sale = request.toEntity();

        List<Product> productList = request.getProductList().stream()
                .map(productId -> productRepository.findById(productId).get())
                .toList();

        sale.setSalesPerson(userRepository.findById(request.getSalesPersonId()).get());
        sale.setListProducts(productList);
        sale.setClient(userService.getUser());
        sale.setDate(LocalDate.now());
        sale.setPrice(productList.stream().
                        map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add));

        salesRepository.save(sale);
    }

    /** Recupera uma venda do banco de dados com base no ID fornecido */
    public Sales getById(Long id) {
        return salesRepository.findById(id).orElseThrow();
    }

    /** Recupera todas as vendas do banco de dados que correspondem à data fornecida. */
    public List<Sales> getByDate(LocalDate date) {
        return salesRepository.findAllByDate(date);
    }

    /** Recupera todas as vendas do banco de dados associadas a um determinado vendedor */
    public List<Sales> getBySalesPerson(Long salesPersonId) {
        return salesRepository.findBySalesPerson(userRepository.findById(salesPersonId).orElseThrow());
    }

    /** Recupera todas as vendas do banco de dados associadas ao cliente atualmente autenticado */
    public List<Sales> getAll() {
        return salesRepository.findAllByClient(userService.getUser());
    }
}
