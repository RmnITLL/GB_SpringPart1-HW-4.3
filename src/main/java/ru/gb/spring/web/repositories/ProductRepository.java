package ru.gb.spring.web.repositories;

import org.springframework.stereotype.Component;
import ru.gb.spring.web.data.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

//    public Product findById(Long id) {
//        return products.stream()
//                .filter(p -> p.getId().equals(id))
//                .findFirst().get();
//    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "tartilla", 10),
                new Product(2L, "burrito", 12),
                new Product(3L, "tacos", 15),
                new Product(4L, "quesadilla", 11),
                new Product(5L, "arepa", 8),
                new Product(6L, "ceviche", 9),
                new Product(7L, "enchilada", 14)
        ));
    }

//    public void deleteById(Long id) {
//        products.removeIf(product -> product.getId().equals(id));
//    }

    public void save(Product p) {products.add(p);}

    public List<Product> getAllProducts() {return Collections.unmodifiableList(products);}

    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteById(Long id) {products.removeIf(p -> p.getId().equals(id));}


}
