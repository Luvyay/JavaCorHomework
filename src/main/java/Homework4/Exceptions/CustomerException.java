package Homework4.Exceptions;

import Homework4.Models.Customer;

public class CustomerException extends Exception {
    private Customer currentCustomer;
    private Customer expectedCustomer;
    public CustomerException(Customer currentCustomer, Customer expectedCustomer) {
        this.currentCustomer = currentCustomer;
        this.expectedCustomer = expectedCustomer;
    }

    @Override
    public String getMessage() {
        return String.format("Не корректный пользователь для данной корзины:\nОжидаем: %s\n" +
                "Поступает: %s",
                expectedCustomer, currentCustomer);
    }
}
