package com.pai.finalprojectbackend.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Product by id " + id + " was not found!"));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteProductById(id);
    }

    public void updateProduct(Long id, Product product) {
        Optional<Product> productToUpdate = productRepository.findProductById(id);
        if(productToUpdate.isPresent()) {
            productRepository.updateProduct(
                    id,
                    product.getProductName(),
                    product.getProductDescription(),
                    product.getProductUnit(),
                    product.getProductPrice(),
                    product.getProductQuantity()
            );
        } else {
            throw new ProductNotFoundException("Product by id " + id + " was not found!");
        }
    }
}
