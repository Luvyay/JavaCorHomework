package Homework4.Exceptions;

import Homework4.Models.Product;

public class ProductException extends Exception {
    private Product product;

    public ProductException(Product product) {
        this.product = product;
    }

    @Override
    public String getMessage() {
        return String.format("Данного товара не существует:\n%s",
                product);
    }
}
