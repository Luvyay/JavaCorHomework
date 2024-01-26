package Homework4.Repository;

import Homework4.Exceptions.RepositoryIndexOutOfRange;
import Homework4.Models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductById(int id) {
        if (id >= 0 && id < products.size()) {
            return products.get(id);
        } else {
            throw new RepositoryIndexOutOfRange(id, products.size());
        }
    }

    public int getSize() {
        return products.size();
    }

    @Override
    public String toString() {
        return "Товары: " + products;
    }
}
