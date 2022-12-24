package com.example.jpahello.response;

import com.example.jpahello.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private String street;
    private String city;
    private String country;
    private String province;
    private String postalCode;

    public AddressResponse(Address address){
        street = address.getStreet();
        city = address.getCity();
        country = address.getCountry();
        province = address.getProvince();
        postalCode = address.getPostalCode();
    }
}
