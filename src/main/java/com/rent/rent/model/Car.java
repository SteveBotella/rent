package com.rent.rent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "modele")
    private String modele;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private int price;

    @Column(name = "image")
    private String image;

    public Car() {
    }

    public Car(int id, String modele, String brand, String color, int price, String image) {
        this.id = id;
        this.modele = modele;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String model) {
        this.modele = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", modele='" + modele + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
