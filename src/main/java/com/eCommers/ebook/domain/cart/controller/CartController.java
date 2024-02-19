package com.eCommers.ebook.domain.cart.controller;

import com.eCommers.ebook.domain.cart.service.CartService;
import com.eCommers.ebook.domain.products.entity.Products;
import com.eCommers.ebook.domain.products.service.ProductsService;
import com.eCommers.ebook.domain.users.entity.Users;
import com.eCommers.ebook.domain.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final UsersService usersService;
    private final ProductsService productsService;

    @GetMapping("/add/{productId}")
    public String addCart(@PathVariable("productId") Integer productId, Principal principal){
        // logined user object
        Users users =  this.usersService.getUsersByName(principal.getName());
        // product add to cart
        Products product = this.productsService.getProduct(productId);

        if(users.getCart() == null){
            this.cartService.cartCreate(users);
        }
        this.cartService.cartAdd(users.getCart(), product);

        return "redirect:/cart/home";
    }

    @GetMapping("/home")
    public String cartHome(Model model, Principal principal){
        Users users = this.usersService.getUsersByName(principal.getName());
        model.addAttribute("productsList", users.getCart().getProductsList());
        return "home/cartHome";
    }
}
