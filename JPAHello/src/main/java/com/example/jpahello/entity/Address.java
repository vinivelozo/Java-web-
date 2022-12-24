package com.example.jpahello.entity;

import com.example.jpahello.request.AddressRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String province;
    @Column(name="postal_code", nullable = false)
    private String postalCode;

    public Address(AddressRequest addressRequest)
    {
        street = addressRequest.getStreet();
        city = addressRequest.getCity();
        country = addressRequest.getCountry();
        province = addressRequest.getProvince();
        postalCode = addressRequest.getPostalCode();
    }
}
