package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto
{
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public static ProductResponseDto from(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setId(product.getId());
        productResponseDto.setTitle(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setCategory(product.getCategory().getName());
        productResponseDto.setImage(product.getImgUrl());

        return productResponseDto;

    }
}
