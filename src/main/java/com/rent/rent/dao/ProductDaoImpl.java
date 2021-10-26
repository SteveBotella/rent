package com.rent.rent.dao;

import com.rent.rent.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, new String("Master"), new String("Renault"), new String("yellow"), 50, new String("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXMjs4cV87nu22LM9klvK49P60pUZMoYbgt7ezrByc8ad6PtidGbn9GJKvN1cajiJJeDg&usqp=CAU")));
        products.add(new Product(10, new String("Ducato"), new String("Fiat"), new String("red"), 60, new String("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTU3IIya8F6A0Vd_hHzWyEim2NkHH7PhTsqG1JW5RfuBt__szBghbAeQBPW0wbSPrOXoVU&usqp=CAU")));
        products.add(new Product(30, new String("Sprinter"), new String("Mercedes"), new String("light grey"), 100, new String("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBTueSHaoXL5_LtVSPLNrA8mZXGcQezMAV99yXBUXrdNWqrkQD4LOI5CjGJrhqyeDUqO0&usqp=CAU")));
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
