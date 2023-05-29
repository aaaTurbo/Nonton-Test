package org.nonton.classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class Productslmpl {

    private HashSet<Product> collection;

    public Productslmpl() {
        this.collection = new HashSet<>();
    }

    public Boolean addProduct(Product product) {
        String addId = product.getId();
        if (collection
                .stream()
                .anyMatch(x -> x.getId().equals(addId))) {
            return false;
        } else {
            collection.add(product);
            return true;
        }
    }

    public Boolean deleteProduct(Product product) {
        Optional remProduct = collection
                .stream()
                .filter(x -> x.getId().equals(product.getId()))
                .findFirst();
        if (remProduct.isPresent()) {
            collection.remove((Product) remProduct.get());
            return true;
        } else {
            return false;
        }
    }

    public String getName(String id) {
        Optional foundProduct = collection
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
        if (foundProduct.isPresent()) {
            Product toReturn = (Product) foundProduct.get();
            return toReturn.getName();
        } else {
            return "";
        }
    }

    public List<String> findByName(String name) {
        List<String> foundProducts = new ArrayList<>();
        collection
                .stream()
                .filter(x -> x.getName().equals(name))
                .forEach(x -> foundProducts.add(x.getId()));
        return foundProducts;
    }

    public HashSet<Product> getCollection() {
        return collection;
    }
}
