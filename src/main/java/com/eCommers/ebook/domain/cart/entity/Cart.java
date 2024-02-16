package com.eCommers.ebook.domain.cart.entity;

import com.eCommers.ebook.domain.products.entity.Products;
import com.eCommers.ebook.domain.users.entity.Users;
import com.eCommers.ebook.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Cart extends BaseEntity {

    @Column
    private Integer totalPrice;

    @Column
    private float totalDiscount;

    @OneToOne
    private Users buyers;

    @OneToMany
    private List<Products> productsList;

}
