package com.tutorial.controller;

import com.tutorial.exception.ResourceNotFoundException;
import com.tutorial.model.Product;
import com.tutorial.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping("/")
    public Product addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return product;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer productId) {
        return ResponseEntity.ok().body(productService.findById(productId));
    }

    @GetMapping("/")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
                                                 @RequestBody Product productDetails) {
        return ResponseEntity.ok(productService.updateProduct(productId, productDetails));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Integer productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

}
