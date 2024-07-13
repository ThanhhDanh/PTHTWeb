/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ltd.repository.impl;

import com.ltd.pojo.Product;
import com.ltd.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    private static final int PAGE_SIZE = 4;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root root = q.from(Product.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String key = params.get("q");
            if (key != null && !key.isEmpty()) {
                Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", key));
                predicates.add(p1);
            }

            String fromPrice = params.get("fromPrice");
            if (fromPrice != null && !fromPrice.isEmpty()) {
                Predicate p2 = b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice));
                predicates.add(p2);
            }

            String toPrice = params.get("toPrice");
            if (toPrice != null && !toPrice.isEmpty()) {
                Predicate p3 = b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice));
                predicates.add(p3);
            }

            String findCate = params.get("findCate");
            if (findCate != null && !findCate.isEmpty()) {
                Predicate p4 = b.like(root.get("manufacturer"), String.format("%%%s%%", findCate));
                predicates.add(p4);
            }

            String cateId = params.get("cateId");
            if (cateId != null && !cateId.isEmpty()) {
                Predicate p5 = b.equal(root.get("category"),
                        Integer.parseInt(cateId)); //root.get("category").as(Integer.class) hibernate 6 trở lên dùng cái này
                predicates.add(p5);
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int start = (p - 1) * PAGE_SIZE;

                query.setFirstResult(start);
                query.setMaxResults(PAGE_SIZE);
            }
        }

        return query.getResultList();

    }

    public void addOrUpdate(Product p) {
        Session s = this.factory.getObject().getCurrentSession();

        if (p.getId() != null) {
            s.update(s);
        } else {
            s.save(s);
        }

    }

    @Override
    public Product getProductById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(Product.class, id);

    }
}
