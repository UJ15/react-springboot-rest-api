package com.example.gccoffee.controller.api;


import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.service.ProductService;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private final ProductService productService;


    public ProductRestController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAllProducts(@RequestParam @Nullable Category category) {

        if (category != null) {
            return productService.getProductsByCategory(category);
        }

        return productService.getAllProducts();
    }



}
