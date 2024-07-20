/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ltd.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ltd.pojo.Product;
import com.ltd.repository.ProductRepository;
import com.ltd.service.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private Cloudinary cloundinary;
    

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.prodRepo.getProducts(params);
    }

    @Override
    public void addOrUpdate(Product p) {
        if (p.getFile().isEmpty()){
            try {
                Map res = this.cloundinary.uploader().upload(p.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.prodRepo.addOrUpdate(p);
    }

    @Override
    public Product getProductById(int id) {
        return this.prodRepo.getProductById(id);
    }
    
}
