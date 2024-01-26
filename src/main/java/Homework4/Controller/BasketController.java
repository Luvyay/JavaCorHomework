package Homework4.Controller;
import Homework4.Exceptions.CustomerException;
import Homework4.Models.Basket;
import Homework4.Models.Customer;
import Homework4.Models.Order;


public class BasketController {
    private Basket basket;

    public BasketController(Customer customer) {
        this.basket = new Basket(customer);
    }

    public void addToBasket(Order order) throws CustomerException {
        boolean isAdd = basket.compareCustomer(order.getCustomer(), order);

        if (!isAdd) {
            throw new CustomerException(this.basket.getCustomer(), order.getCustomer());
        }
    }

    @Override
    public String toString() {
        return basket.toString();
    }
}
