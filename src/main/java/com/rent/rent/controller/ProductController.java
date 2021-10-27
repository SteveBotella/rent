package com.rent.rent.controller;

import com.rent.rent.dao.ProductDao;
import com.rent.rent.dao.ProductDaoImpl;
import com.rent.rent.form.ProductForm;
import com.rent.rent.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller//The answer will be Json
public class ProductController {

    @Value("${error.message}")
    private String errorMessage;

    @Autowired //TODO C'est quoi ?
    private ProductDao productDao;

    //Products
    @GetMapping(value = "/products")
    public String productsList(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("listproducts", productDao.findAll());
        return "productsList";
    }

    @GetMapping(value = "products/{id}") //Call this methode only for a get request
    public String product(@RequestParam(name = "name", required = false, defaultValue = "") String name, @PathVariable int id, Model model) {
        model.addAttribute("showProduct", productDao.findById(id));
        return "product";
    }

    @GetMapping(value = {"/addproduct"})
    public String showAddProduct(Model model) {

        ProductForm productForm = new ProductForm();
        model.addAttribute("productForm", productForm);

        return "addProduct";
    }

    @RequestMapping(value = {"/addproduct"}, method = RequestMethod.POST)
    public String saveProduct(Model model,
                              @ModelAttribute("productForm") ProductForm productForm) {

        int id = productForm.getId();
        String brand = productForm.getBrand();
        String modele = productForm.getModele();
        String color = productForm.getColor();
        int price = productForm.getPrice();
        String image = productForm.getImage();

        if (brand != null && brand.length() > 0 //
                && modele != null && modele.length() > 0) {
            Product newProduct = new Product(id, modele, brand, color, price, image);
            ProductDaoImpl.products.add(newProduct);
            model.addAttribute("listproducts", productDao.findAll());
            return "productsList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addProduct";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model) {
        Product product = productDao.findById(id);
        productDao.delete(product);
        model.addAttribute("listproducts", productDao.findAll());
        return "productsList";
    }
}