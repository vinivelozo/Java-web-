package com.example.jpahello.response;


import com.example.jpahello.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private long id;
    private String name;
    private int credits;
    private ClientResponse client;

    public ProductResponse(Product product){
        id = product.getId();
        name = product.getName();
        credits = product.getCredits();
        client = new ClientResponse(product.getClient());
    }
}
