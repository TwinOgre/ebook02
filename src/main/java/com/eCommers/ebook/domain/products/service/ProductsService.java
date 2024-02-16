package com.eCommers.ebook.domain.products.service;

import com.eCommers.ebook.domain.products.ProductsForm;
import com.eCommers.ebook.domain.products.entity.Products;
import com.eCommers.ebook.domain.products.repository.ProductsRepository;
import com.eCommers.ebook.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public void createProducts(ProductsForm productsForm, Users seller){
        Products products = Products.builder()
                .productName(productsForm.getProductName())
                .productIntroduce(productsForm.getProductIntroduce())
                .price(productsForm.getPrice())
                .discount(productsForm.getDiscount())
                .averageRating(0)
                .isReported(false)
                .seller(seller)
                .createDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        this.productsRepository.save(products);
    }

    public void modifyProducts(ProductsForm productsForm, Products products){
        Products productsModify = products.toBuilder()
                .productName(productsForm.getProductName())
                .productIntroduce(productsForm.getProductIntroduce())
                .price(productsForm.getPrice())
                .discount(productsForm.getDiscount())
                .build();

        this.productsRepository.save(productsModify);
    }

    public void deleteProducts(Products products){
        this.productsRepository.delete(products);
    }

    public List<Products> productsList(){
        return this.productsRepository.findAll();
    }
}
