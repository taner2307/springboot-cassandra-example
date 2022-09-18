package com.tutorial.service;

import com.tutorial.model.Product;

import java.util.List;

public interface IProductService {

    Product addProduct(Product product);

    Product findById(Integer id);

    List<Product> getProducts();

    Product updateProduct(Integer id,Product product);

    void deleteProduct(Integer id);
}
