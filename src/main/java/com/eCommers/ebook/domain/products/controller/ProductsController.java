package com.eCommers.ebook.domain.products.controller;

import com.eCommers.ebook.domain.products.ProductsForm;
import com.eCommers.ebook.domain.products.entity.Products;
import com.eCommers.ebook.domain.products.service.ProductsService;
import com.eCommers.ebook.domain.users.entity.Users;
import com.eCommers.ebook.domain.users.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController{
    private final ProductsService productsService;
    private final UsersService usersService;

    @GetMapping("/list")
    public String productList(Model model){
        List<Products> productsList = this.productsService.productsList();

        model.addAttribute("productsList", productsList);
        return "products/productList";
    }

    @GetMapping("/create")
    public String productCreate(ProductsForm productsForm){

        return "products/productForm";
    }

    @PostMapping("/create")
    public String productCreate(@Valid ProductsForm productsForm, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            return "products/productForm";
        }
        Users seller = this.usersService.getUsersByName(principal.getName());
        this.productsService.createProducts(productsForm, seller);

        return "redirect:/products/list";
    }


}
