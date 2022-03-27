package com.pai.finalprojectbackend.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        List<Product> products = productService.findAllProduct();

        model.addAttribute("productsList", products);

        return "productsPage";
    }

    @GetMapping("/add")
    public String addProductPage(Model model) {
        model.addAttribute("productToAdd", new Product());

        return "addProductPage";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute(value = "productToAdd") Product product, BindingResult binding) {
        if(binding.hasErrors()) {
            return "addProductPage";
        }
        productService.addProduct(product);

        return "redirect:/products/all";
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
//        Product product = productService.findProductById(id);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);

        return "redirect:/products/all";
    }

    @PostMapping("/update")
    public String showUpdateForm(@ModelAttribute(value = "productToEdit") Product product, Model model) {
        model.addAttribute("productToUpdate", product);

        return "updateForm";
    }

    @PostMapping("update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @Valid @ModelAttribute("productToUpdate") Product product, BindingResult binding) {
        if(binding.hasErrors()) {
            System.out.println(binding);
            System.out.println(product);

            return "updateForm";
        }
        productService.updateProduct(id, product);

        return "redirect:/products/all";
    }
}
