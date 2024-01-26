package Homework4.Models;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private Customer customer;
    private List<Order> orders;

    public Basket(Customer customer) {
        this.customer = customer;
        this.orders = new ArrayList<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    private void add(Order order) {
        orders.add(order);
    }

    public boolean compareCustomer(Customer customer, Order order) {
        if (this.customer.compareTo(customer) == 0) {
            add(order);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s\nСписок товаров: %s",
                customer, orders);
    }
}
