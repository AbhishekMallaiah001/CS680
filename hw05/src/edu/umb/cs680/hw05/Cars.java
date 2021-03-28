package edu.umb.cs680.hw05;


public class Cars {
    private String make, model;
    private int mileage, year;
    private float price;

    public Cars(String make, String model, int mileage, int year, float price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getYear() {
        return this.year;
    }

    public float getPrice() {
        return this.price;
    }

    public static void main(String[] args) {
        Cars c = new Cars("maruthi", "baleno", 20, 2016, 8 );
    }
}