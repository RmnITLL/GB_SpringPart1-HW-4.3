package ru.gb.spring.web.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.spring.web.data.Product;
import ru.gb.spring.web.services.ProductService;

import java.util.List;

@RestController
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }

}
