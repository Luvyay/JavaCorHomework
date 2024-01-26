package Homework4.Models;

public class Order {
    private Customer customer;
    private Product product;
    private int piece;

    public Order(Customer customer, Product product, int piece) {
        this.customer = customer;
        this.product = product;
        this.piece = piece;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return String.format("Покупатель: %s\nТовар: %s; %s шт.",
                customer, product, piece);
    }
}
