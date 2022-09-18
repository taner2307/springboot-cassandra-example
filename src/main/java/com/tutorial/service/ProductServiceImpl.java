package com.tutorial.service;

import com.tutorial.exception.ResourceNotFoundException;
import com.tutorial.model.Product;
import com.tutorial.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product not found " + id));

        return product;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Integer id, Product productDetail) {
        Product product = productRepository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        product.setName(productDetail.getName());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product not found::: " + id));
        productRepository.delete(product);
    }
}
