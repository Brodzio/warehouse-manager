package com.pai.finalprojectbackend.Product;

import lombok.Data;

@Data
public class ProductDTO {

    private String productName;
    private String productDescription;
    private String productUnit;
    private Float productPrice;
    private Integer productQuantity;
}
