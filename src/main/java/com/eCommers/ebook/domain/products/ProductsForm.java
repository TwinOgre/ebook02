package com.eCommers.ebook.domain.products;

import  jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsForm {

    @NotEmpty(message = "please write productName")
    private String productName;

    @NotEmpty(message = "please write productIntroduce")
    private String productIntroduce;

    @NotNull
    private int price;

    @NotNull
    private float discount;
}
