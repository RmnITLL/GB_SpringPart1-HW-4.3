package ru.gb.spring.web.services;

import org.springframework.stereotype.Service;
import ru.gb.spring.web.data.Product;
import ru.gb.spring.web.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changeCost(Long id, Integer delta) {
        Product product = productRepository.findById(id);
        Integer newCost = product.getCost();
        newCost = newCost + delta;
        if (newCost < 1) {
            newCost = 0;
        }
        product.setCost(newCost);
        productRepository.deleteById(id);
        productRepository.save(product);
    }
}
