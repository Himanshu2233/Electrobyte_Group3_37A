// model/Product.java
package model;

public class Product {
    private String name;
    private double price;
    private String image;

    public Product(String name, double price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    // Optional: toString for printing/debugging
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", image='" + image + "'}";
    }
}
