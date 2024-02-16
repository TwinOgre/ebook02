package com.eCommers.ebook.domain.products.service;

import com.eCommers.ebook.domain.products.ProductsForm;
import com.eCommers.ebook.domain.products.entity.Products;
import com.eCommers.ebook.domain.products.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public Products createProducts(ProductsForm productsForm){
        Products products = Products.builder()
                .productName(productsForm.getProductName())
                .productIntroduce(productsForm.getProductIntroduce())
                .price(productsForm.getPrice())
                .discount(productsForm.getDiscount())
                .averageRating(0)
                .isReported(false)
                .createDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        this.productsRepository.save(products);


        return products;
    }
}
