package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDto
{
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public Product toProduct()
    {
        Product product = new Product();
        product.setId(id);
        product.setName(title);
        product.setDescription(description);
        product.setImgUrl(image);
        product.setPrice(price);

        Category category1 = new Category();
        category1.setName(category);

        product.setCategory(category1);

        return product;
    }
}
