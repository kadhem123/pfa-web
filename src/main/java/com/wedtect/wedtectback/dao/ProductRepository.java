package com.wedtect.wedtectback.dao;


import com.wedtect.wedtectback.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Long countById(Integer id);
}
