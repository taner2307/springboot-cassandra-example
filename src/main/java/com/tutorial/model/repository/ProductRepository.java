package com.tutorial.model.repository;

import com.tutorial.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProductRepository extends CassandraRepository<Product, Integer> {
}
