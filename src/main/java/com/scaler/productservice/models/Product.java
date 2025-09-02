package com.scaler.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product
{
    private long id;
    private String name;
    private double price;
    private String description;
    private String imgUrl;
    private Category category;
}
