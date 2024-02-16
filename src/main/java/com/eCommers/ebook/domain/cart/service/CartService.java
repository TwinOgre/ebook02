package com.eCommers.ebook.domain.cart.service;

import com.eCommers.ebook.domain.cart.entity.Cart;
import com.eCommers.ebook.domain.cart.repository.CartRepository;
import com.eCommers.ebook.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Cart cartCreate(Users buyer){
        Cart cart = Cart.builder()
                .totalPrice(0)
                .totalDiscount(0)
                .buyer(buyer)
                .productsList(null)
                .build();

        this.cartRepository.save(cart);
        return cart;
    }
}
