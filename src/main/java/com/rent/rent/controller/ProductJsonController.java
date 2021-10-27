package com.rent.rent.controller;

import com.rent.rent.dao.ProductDao;
import com.rent.rent.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //The answer will be Json
public class ProductJsonController {

    @Autowired
    private ProductDao productDao;

    //Show all Products
    @GetMapping(value = "productsJson")
    public List<Product> listproducts(){
        return productDao.findAll();
    }

    //Show one product
    @GetMapping(value = "productsJson/{id}") //Call this methode only for a get request
    public Product displayProduct(@PathVariable int id){
        return productDao.findById(id);
    }

    //Delete one product
    @GetMapping(value = "/deleteJson/{id}")
    public Product delete(@PathVariable int id) {
        Product product = productDao.findById(id);
        return productDao.delete(product);
    }
}