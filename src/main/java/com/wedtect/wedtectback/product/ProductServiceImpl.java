package com.wedtect.wedtectback.product;

import com.wedtect.wedtectback.dao.ProductRepository;
import com.wedtect.wedtectback.entities.Product;
import com.wedtect.wedtectback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> listAll(){
        return (List<Product>) repo.findAll();
    }
    public void save(Product product){
        repo.save(product);

    }
    public Product get(Integer id) throws ProductNotFoundException {
        Optional<Product> result=repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new ProductNotFoundException("Could not find any product with id " + id);
    }

    public void delete(Integer id) throws ProductNotFoundException {
        Long count=  repo.countById(id);
        if(count == null || count == 0){
            throw new ProductNotFoundException("Could not find any product with id" + id);
        }
        repo.deleteById(id);
    }



}
