package Homework4.Repository;

import Homework4.Exceptions.RepositoryIndexOutOfRange;
import Homework4.Models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer getCustomerById(int id) {
        if (id >= 0 && id < customers.size()) {
            return customers.get(id);
        } else {
            throw new RepositoryIndexOutOfRange(id, customers.size());
        }
    }

    public int getSize() {
        return customers.size();
    }

    @Override
    public String toString() {
        return "Покупатели: " + customers;
    }
}
