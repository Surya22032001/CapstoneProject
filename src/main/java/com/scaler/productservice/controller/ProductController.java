package com.scaler.productservice.controller;

import com.scaler.productservice.dtos.CreateFakeStoreProductRequestDto;
import com.scaler.productservice.dtos.ErrorDto;
import com.scaler.productservice.dtos.ProductResponseDto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") long id) throws ProductNotFoundException {
        Product product=productService.getProductById(id);
        return ProductResponseDto.from(product);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts(){
        List<Product> products=productService.getAllProducts();

        List<ProductResponseDto> productResponseDtos=new ArrayList<>();
        for(Product product:products){
            productResponseDtos.add(ProductResponseDto.from(product));
        }

        return productResponseDtos;
    }

    public ResponseEntity<ProductResponseDto> createProduct(
            @RequestBody CreateFakeStoreProductRequestDto
                    createFakeStoreProductRequestDto)
    {
        Product product=productService.createProduct(
                createFakeStoreProductRequestDto.getName(),
                createFakeStoreProductRequestDto.getDescription(),
                createFakeStoreProductRequestDto.getPrice(),
                createFakeStoreProductRequestDto.getImage(),
                createFakeStoreProductRequestDto.getCategory()
                );
        return new ResponseEntity<>(ProductResponseDto.from(product), HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ProductResponseDto replaceProduct(@PathVariable("id") long id,
                                             @RequestBody CreateFakeStoreProductRequestDto
                                                     createFakeStoreProductRequestDto)
    {
        Product product=productService.replaceProduct(
                id,
                createFakeStoreProductRequestDto.getName(),
                createFakeStoreProductRequestDto.getDescription(),
                createFakeStoreProductRequestDto.getPrice(),
                createFakeStoreProductRequestDto.getImage(),
                createFakeStoreProductRequestDto.getCategory()
        );

        return ProductResponseDto.from(product);
    }



//    @ExceptionHandler(NullPointerException.class)
//    public ErrorDto handleNullPointerException(){
//        ErrorDto errorDto=new ErrorDto();
//        errorDto.setMessage("Failure");
//        errorDto.setMessage("Product cannot be null");
//
//        return errorDto;
//    }
}
