package com.pai.finalprojectbackend.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductById(Long id);

    void deleteProductById(Long id);

    @Query("UPDATE Product set productName = :productName, productDescription = :productDescription, productUnit = :productUnit, productPrice = :productPrice, productQuantity = :productQuantity where id = :id")
    @Modifying
    public void updateProduct(
            @Param("id") Long id,
            @Param("productName") String productName,
            @Param("productDescription") String productDescription,
            @Param("productUnit") String productUnit,
            @Param("productPrice") Float productPrice,
            @Param("productQuantity") Integer productQuantity
    );
}
