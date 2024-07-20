/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ltd.controllers;

import com.ltd.pojo.Product;
import com.ltd.service.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author admin
 */
@Controller
public class ProductController {
    
    @Autowired
    private ProductService prodService;
    
    @GetMapping("/products")
    public String productView(Model model) {
        model.addAttribute("product", new Product());
        return "products";
    }
    
    @PostMapping("/products")
    public String create(Model model, @ModelAttribute(value = "product")@Valid Product p, BindingResult rs) {
        if( rs.hasErrors())
            return "products";
        this.prodService.addOrUpdate(p);
        return "redirect:/";
    }
}
