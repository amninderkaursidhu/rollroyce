package com.carrental.car_rental;

public class vehcileinformation {

    String type,brand,model,year,color,licenceplate,image;

    public vehcileinformation(String type, String brand, String model, String year, String color, String licenceplate, String image)
    {
        this.brand=brand;
        this.type=type;
        this.color=color;
        this.model=model;
        this.year=year;
        this.color=color;
        this.licenceplate=licenceplate;
        this.image=image;

    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicenceplate() {
        return licenceplate;
    }

    public void setLicenceplate(String licenceplate) {
        this.licenceplate = licenceplate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
