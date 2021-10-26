package com.rent.rent.dao;

import com.rent.rent.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, new String("Renault Master"), 50));
        products.add(new Product(10, new String("Fiat Ducato"), 60));
        products.add(new Product(30, new String("Mercedes Sprinter"), 100));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
