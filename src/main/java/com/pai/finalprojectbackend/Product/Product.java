package com.pai.finalprojectbackend.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    @NotBlank(message = "Puste pole!")
    private String productName;

    @Column(name = "product_description")
    @NotBlank(message = "Puste pole!")
    private String productDescription;

    @Column(name = "product_unit")
    @NotBlank(message = "Puste pole!")
    private String productUnit;

    @Column(name = "product_price")
    private Float productPrice;

    @Column(name = "product_quantity")
    private Integer productQuantity;
}
