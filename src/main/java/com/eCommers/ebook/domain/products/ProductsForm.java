package com.eCommers.ebook.domain.products;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsForm {

    @NotEmpty(message = "please write productName")
    private String productName;

    @NotEmpty(message = "please write productIntroduce")
    private String productIntroduce;

    @NotEmpty(message = "please write price")
    private Integer price;

    @NotEmpty(message = "please write discount")
    private float discount;
}
