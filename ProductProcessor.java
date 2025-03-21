Q3. Write a Java program to process a large dataset of products using Streams. The program should perform operations such as grouping products by category, finding the most expensive product in each category, and calculating the average price of all products.
  

import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    // Constructor
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        // Creating a list of products
        List<Product> products = Arrays.asList(
                new Product("ProductA", "Electronics", 500),
                new Product("ProductB", "Electronics", 1500),
                new Product("ProductC", "Furniture", 300),
                new Product("ProductD", "Furniture", 700),
                new Product("ProductE", "Electronics", 1000),
                new Product("ProductF", "Clothing", 50),
                new Product("ProductG", "Clothing", 100),
                new Product("ProductH", "Furniture", 600),
                new Product("ProductI", "Clothing", 200),
                new Product("ProductJ", "Electronics", 2000)
        );

        // 1. Grouping products by category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // 2. Finding the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveProductInCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveProductInCategory.forEach((category, productOpt) -> {
            productOpt.ifPresent(product -> System.out.println(category + ": " + product));
        });

        // 3. Calculating the average price of all products
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}


OUTPUT:

Products grouped by category:
Clothing: [Product{name='ProductF', category='Clothing', price=50.0}, Product{name='ProductG', category='Clothing', price=100.0}, Product{name='ProductI', category='Clothing', price=200.0}]
Electronics: [Product{name='ProductA', category='Electronics', price=500.0}, Product{name='ProductB', category='Electronics', price=1500.0}, Product{name='ProductE', category='Electronics', price=1000.0}, Product{name='ProductJ', category='Electronics', price=2000.0}]
Furniture: [Product{name='ProductC', category='Furniture', price=300.0}, Product{name='ProductD', category='Furniture', price=700.0}, Product{name='ProductH', category='Furniture', price=600.0}]

Most expensive product in each category:
Clothing: Product{name='ProductI', category='Clothing', price=200.0}
Electronics: Product{name='ProductJ', category='Electronics', price=2000.0}
Furniture: Product{name='ProductD', category='Furniture', price=700.0}

Average price of all products: 695.0
