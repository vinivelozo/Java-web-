package com.example.jpahello.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequest {

    @NotBlank
    private String name;
    @NotNull
    private Integer credits;


}
