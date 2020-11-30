package com.marchuk0.lab2;

public class Car {
    private String brand;
    private String model;
    private String color;
    private Integer price;
    private Integer year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{\n" +
                "   brand=" + brand + '\n' +
                "   model=" + model + '\n' +
                "   color=" + color + '\n' +
                "   price=" + price + '\n' +
                "   year=" + year + '\n' +
                '}';
    }
}

