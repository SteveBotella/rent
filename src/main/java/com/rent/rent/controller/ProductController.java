package com.rent.rent.controller;

import com.rent.rent.dao.ProductDao;
import com.rent.rent.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller//The answer will be Json
public class ProductController {

    @Autowired //TODO C'est quoi ?
    private ProductDao productDao;

    //Products
    @GetMapping(value = "/products")
    public String productsList(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("listproducts", productDao.findAll());
        return "productsList";
    }

    @GetMapping(value = "products/{id}") //Call this methode only for a get request
    public String product(@RequestParam(name ="name", required = false, defaultValue = "") String name, @PathVariable int id, Model model) {
        model.addAttribute("showProduct", productDao.findById(id));
        return "product";
    }
}