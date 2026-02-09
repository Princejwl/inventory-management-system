package com.example.inventory_system.controller;

import com.example.inventory_system.model.Product;
import com.example.inventory_system.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }


    @PutMapping("/{id}/quantity")
    public Product updateQuantity(@PathVariable Long id, @RequestParam int quantity) {
        return service.updateQuantity(id, quantity);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return "Product deleted successfully";
    }
}
