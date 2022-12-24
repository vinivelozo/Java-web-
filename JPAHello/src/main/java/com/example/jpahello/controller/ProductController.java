package com.example.jpahello.controller;

import com.example.jpahello.request.ProductRequest;
import com.example.jpahello.response.ProductResponse;
import com.example.jpahello.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //GET /api/courses/:courseId
    @GetMapping("/{productId}")
    public ProductResponse getProduct(@PathVariable long productId) {
        return new ProductResponse(productService.getProduct(productId));
    }

    @PutMapping("/{productId}")
    public ProductResponse updateProduct(@PathVariable long productId, @Valid @RequestBody ProductRequest productRequest){
        return new ProductResponse(productService.updateProduct(productId, productRequest));
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable long productId)
    {
        productService.deleteProduct(productId);
    }
}
