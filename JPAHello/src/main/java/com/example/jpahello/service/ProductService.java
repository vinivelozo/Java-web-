package com.example.jpahello.service;

import com.example.jpahello.entity.Product;
import com.example.jpahello.exception.ResourceNotFoundException;
import com.example.jpahello.repository.ProductRepository;
import com.example.jpahello.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(long productId)
    {
        Product product = productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("product id not found"));
        return product;
    }

    public Product updateProduct(long productId, ProductRequest productRequest){
        if(productRepository.existsById(productId))
        {
            Product productToBeUpdated = new Product(productRequest);
            productToBeUpdated.setId(productId);
            return productRepository.save(productToBeUpdated);
        }
        else{
            throw new ResourceNotFoundException("product id not found");
        }
    }

    public void deleteProduct(long productId){
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
        }
        else{
            throw new ResourceNotFoundException("product id not found");

        }
    }
}
