package com.wedtect.wedtectback.service;

import com.wedtect.wedtectback.entities.Product;
import com.wedtect.wedtectback.product.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    public List<Product> listAll();
    void save(Product product);
    public Product get(Integer id) throws ProductNotFoundException;
    public void delete(Integer id) throws ProductNotFoundException;
}
