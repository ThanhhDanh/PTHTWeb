/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hibernate;

import com.ltd.pojo.Cart;
import com.ltd.repository.impl.CategoryRepositoryImpl;
import com.ltd.repository.impl.ProductRepositoryImpl;
import com.ltd.repository.impl.ReceiptRepositoryImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class Hibernate {

    public static void main(String[] args) {
        
        List<Cart> carts = new ArrayList<>();
        carts.add(new Cart(1, "SamSung123", 2, 10000l));
        
        ReceiptRepositoryImpl r = new ReceiptRepositoryImpl();
        r.addReceipt(carts);
        
        
//        Map<String, String> params = new HashMap<>();
        
//        params.put("q", "iPhone");
//        params.put("fromPrice", "11000000"); 
//        params.put("toPrice", "28000000");
//        params.put("findCate", "Samsung");
//        params.put("page", "2");



//        ProductRepositoryImpl p = new ProductRepositoryImpl();
//        p.getProducts(params).forEach(product -> System.out.printf("%s - %.1f - %s\n", 
//                product.getName(), product.getPrice(), product.getManufacturer()));
//        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
//        s.getCates().forEach(c -> System.out.println(c.getName()));
    }
}
