package com.eCommers.ebook.domain.cart.service;

import com.eCommers.ebook.domain.cart.entity.Cart;
import com.eCommers.ebook.domain.cart.repository.CartRepository;
import com.eCommers.ebook.domain.products.entity.Products;
import com.eCommers.ebook.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void cartAdd(Cart cart, Products product){
        List<Products> productsList = cart.getBuyer().getProductsList();
        productsList.add(product);
        Integer totalPrice = cart.getTotalPrice();

        Cart cart1 = cart.toBuilder()
                .productsList(productsList)
                .totalPrice(totalPrice + product.getPrice())
                //Discount 수정 필요
                //.totalDiscount()
                .build();
        this.cartRepository.save(cart1);
    }
}
