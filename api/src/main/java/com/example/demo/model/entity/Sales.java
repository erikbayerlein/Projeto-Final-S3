package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "sales_salesPerson",
            joinColumns = @JoinColumn(name = "sales_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User salesPerson;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "listProducts", nullable = false)
    private List<Product> listProducts;

    @Column(name = "date", nullable = false)
    private String date; // pesquisar para alterar

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "sales_client",
            joinColumns = @JoinColumn(name = "sales_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User client;

    public Sales(List<Product> listProduct, User salesPerson, BigDecimal price, String date) {
        this.salesPerson = salesPerson;
        this.price = price;
        this.date = date;
        this.listProducts = listProduct;
    }
}
