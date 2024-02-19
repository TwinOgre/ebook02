package com.eCommers.ebook.domain.users.entity;

import com.eCommers.ebook.domain.cart.entity.Cart;
import com.eCommers.ebook.domain.products.entity.Products;
import com.eCommers.ebook.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Users extends BaseEntity {

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String nickname;

    @Column
    private String email;

    private String password;

    @Column
    private String role;

    @Column
    private boolean isSeller;

    // 판매자일 때 판매물품
    @OneToMany
    private List<Products> productsList;

    @OneToOne
    private Cart cart;
}
