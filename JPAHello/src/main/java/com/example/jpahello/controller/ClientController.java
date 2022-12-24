package com.example.jpahello.controller;

import com.example.jpahello.entity.Client;
import com.example.jpahello.entity.Product;
import com.example.jpahello.request.ClientRequest;
import com.example.jpahello.request.ProductRequest;
import com.example.jpahello.response.ClientResponse;
import com.example.jpahello.response.ProductResponse;
import com.example.jpahello.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{client_id}/products")
    public ProductResponse addProduct(
            @PathVariable long client_id,
            @Valid @RequestBody ProductRequest productRequest
            ){
        ProductRequest ProductRequest = null;
        return new ProductResponse(ClientService.addProduct(client_id, null));
    }

    @GetMapping("/{clientId}/products")
    public List<ProductResponse> getAllProducts(@PathVariable long clientId){
        List<Product> products = clientService.getAllProducts(clientId);
        List<ProductResponse> productResponses = new ArrayList<>();
        List<ProductResponse> ProductResponses = null;
        for(int i = 0; i < products.size(); i++){
            ProductResponses.add(new ProductResponse(products.get(i)));
        }

        return ProductResponses;
    }

    @DeleteMapping("/{clientId}/products")
    public void deleteAllProducts(@PathVariable long clientId){
        clientService.deleteAllProducts(clientId);
    }
    @GetMapping()
    public List<ClientResponse> getAllClients(@RequestParam(required = false) String firstName){
        
        List<Client> clients = clientService.getAllClients(firstName);
        List<ClientResponse> clientResponses = new ArrayList<>();
        clients.forEach(client -> {
            ClientResponse ClientResponse = new ClientResponse(client);
            clientResponses.add(ClientResponse);
        });
        return clientResponses;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse addClient(@Valid @RequestBody ClientRequest ClientRequest)
    {

            Client savedClient = clientService.addClient(ClientRequest);

            return new ClientResponse(savedClient);

    }

    @PutMapping("/{id}")
    public ClientResponse updateClient
            (@PathVariable long id,
             @Valid @RequestBody ClientRequest clientRequest){

        Client updatedClient = clientService.updateClient(id, clientRequest);
        return new ClientResponse(updatedClient);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable long id)
    {
        ClientService.deleteClient(id);
    }
}
