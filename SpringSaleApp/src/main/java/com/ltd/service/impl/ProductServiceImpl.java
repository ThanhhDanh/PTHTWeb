/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ltd.service.impl;

import com.ltd.pojo.Product;
import com.ltd.repository.ProductRepository;
import com.ltd.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository prodRepo;
    

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.prodRepo.getProducts(params);
    }

    @Override
    public void addOrUpdate(Product p) {
        this.prodRepo.addOrUpdate(p);
            }

    @Override
    public Product getProductById(int id) {
        return this.prodRepo.getProductById(id);
    }
    
}
