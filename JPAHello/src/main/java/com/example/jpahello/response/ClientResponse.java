package com.example.jpahello.response;

import com.example.jpahello.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    private long id;
    private String fullName;
    //private String lastName;
    private String email;

    private int age;

    private AddressResponse address;
    public ClientResponse(Client client){
        id = client.getId();
        fullName = client.getFirstName() + " " + client.getLastName();
        //lastName = client.getLastName();
        email = client.getEmail();
        age = client.getAge();
        address = new AddressResponse(client.getAddress());
    }
}
