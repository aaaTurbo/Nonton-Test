package org.nonton;

import org.nonton.classes.Product;
import org.nonton.classes.Productslmpl;

public class Main {
    public static void main(String[] args) {
        Productslmpl productslmpl = new Productslmpl();
        System.out.println(productslmpl.addProduct(new Product("1", "First"))); // true
        System.out.println(productslmpl.addProduct(new Product("1", "Second"))); // false
        System.out.println(productslmpl.addProduct(new Product("2", "Third"))); // true
        System.out.println(productslmpl.addProduct(new Product("2", "Fourth"))); // false
        productslmpl.getCollection().forEach(System.out::println); // Products [{1, First}, {2, Third}]
        System.out.println(productslmpl.deleteProduct(new Product("2", "Third"))); // true
        System.out.println(productslmpl.deleteProduct(new Product("2", "Third"))); //false
        productslmpl.getCollection().forEach(System.out::println); // Product {1, First}
        System.out.println(productslmpl.getName("1")); // First
        System.out.println(productslmpl.getName("2"));  // Empty line
        System.out.println(productslmpl.addProduct(new Product("2", "First"))); // true
        productslmpl.findByName("First").forEach(System.out::println); // 2 \n 1
        productslmpl.getCollection().forEach(System.out::println); // Products [{1, First}, {2, First}]
    }
}