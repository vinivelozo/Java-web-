package com.example.jpahello.service;

import com.example.jpahello.entity.Product;
import com.example.jpahello.entity.Client;
import com.example.jpahello.exception.ResourceNotFoundException;
import com.example.jpahello.repository.ProductRepository;
import com.example.jpahello.repository.ClientRepository;
import com.example.jpahello.request.ProductRequest;
import com.example.jpahello.request.ClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    static
    ClientRepository clientRepository;
    @Autowired
    static
    ProductRepository productRepository;



    public static Product addProduct(long client_id, ProductRequest productRequest){
        Client client =  clientRepository.findById(client_id).orElseThrow(
                ()->new ResourceNotFoundException("client id is not found"));

        Product productToBeSaved = new Product(productRequest);
        productToBeSaved.setClient(client);

        return productRepository.save(productToBeSaved);
    }

    public List<Product> getAllProducts(long clientId){
        return productRepository.findAllByClientId(clientId);
    }
    public void deleteAllCourses(long clientId){
        if(clientRepository.existsById(clientId)){
            productRepository.deleteAllByClientId(clientId);
        }
        else{
            throw new ResourceNotFoundException("client id not found");
        }
    }
    public List<Client> getAllClients(String firstNameParam){
        if(firstNameParam == null || firstNameParam.isBlank())
            return (List<Client>) clientRepository.findAll();


        return clientRepository.findAllByFirstNameIgnoreCase(firstNameParam);
    }

    public Client addClient(ClientRequest clientRequest)
    {
        Client client = new Client(clientRequest);

        return clientRepository.save(client);
    }

    public Client updateClient(long teacherId, ClientRequest clientRequest)
    {
        clientRepository.findById(teacherId)
                .orElseThrow(()->new ResourceNotFoundException("client id is not found"));

        Client clientToBeUpdated = new Client(clientRequest);
        clientToBeUpdated.setId(teacherId);

        return clientRepository.save(clientToBeUpdated);

    }

    public static void deleteClient(long clientId){
        if(clientRepository.existsById(clientId)){
            clientRepository.deleteById(clientId);
        }
        else{
            throw new ResourceNotFoundException("client id not found");
        }
    }


    public void deleteAllProducts(long clientId) {
    }
}
