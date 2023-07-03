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

        // ****************************************************************** //
        // PRIMEIRA ABORDAGEM (creio que funciona)
//        BigDecimal total = new BigDecimal(0);
//        BigDecimal price;
//        for (Product product: productList){
//            price = product.getPrice();
//            total = total.add(price);
//        }
        // ****************************************************************** //


        sale.setSalesPerson(userRepository.findById(request.getSalesPersonId()).get());
        sale.setListProducts(productList);
        sale.setClient(userService.getUser());
        sale.setDate(LocalDate.now());
        sale.setPrice(productList.stream().
                        map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add));


        // ****************************************************************** //
        // SEGUNDA ABORDAGEM (checar se funciona e corrigir o que estier errado)
        // tive que converter para double, pois não estava funcionando com o big decimal
//        BigDecimal total2;
//        total2 = new BigDecimal(productList.stream().mapToDouble(product -> product.getPrice().doubleValue()).sum());
        // ****************************************************************** //


        // ****************************************************************** //
        // OUTRAS TENTATIVAS
        /*total = total.add(productList.forEach(product -> product.getPrice()));

        BigDecimal sum = new BigDecimal(productList.forEach(product -> total = total.add(product.getPrice())).toString());

        double valor = produtos
        // cria o stream
        .stream()
        // obtém os valores das vendas de todos os produtos
        .mapToDouble(produto -> produto.getValor(Venda.class))
        // soma tudo
        .sum();

        sale.setPrice(productList.forEach(product -> total = total.add(product.getPrice())));*/
        // ****************************************************************** //

        salesRepository.save(sale);
    }

    public Sales getById(Long id) {
        return salesRepository.findById(id).orElseThrow();
    }

    public List<Sales> getByDate(LocalDate date) {
        return salesRepository.findAllByDate(date);
    }

    public List<Sales> getBySalesPerson(Long salesPersonId) {
        return salesRepository.findBySalesPerson(userRepository.findById(salesPersonId).orElseThrow());
    }

    public List<Sales> getAll() {
        return salesRepository.findAllByClient(userService.getUser());
    }
}
