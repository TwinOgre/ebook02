package com.eCommers.ebook.domain.cart.controller;

import com.eCommers.ebook.domain.cart.service.CartService;
import com.eCommers.ebook.domain.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final UsersService usersService;

    @GetMapping("/add/{productId}")
    public String addCart(Model model, @PathVariable("productId") Integer productId, Principal principal){


        return "cart/cartHome";
    }
}
