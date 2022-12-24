package com.example.jpahello.entity;

import com.example.jpahello.request.ClientRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="clients")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="last_name", nullable = false)
    private String lastName;
    @Column(name="email", nullable = false)
    private String email;

    @Column(name="age", nullable = false)
    private int age;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Address address;

    public Client(ClientRequest clientRequest)
    {
        firstName = clientRequest.getFirstName();
        lastName = clientRequest.getLastName();
        email = clientRequest.getEmail();
        age = clientRequest.getAge();

        address = new Address(clientRequest.getAddress());
    }

}
