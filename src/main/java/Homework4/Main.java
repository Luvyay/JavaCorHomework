package Homework4;

import Homework4.Controller.BasketController;
import Homework4.Controller.OrderController;
import Homework4.Exceptions.AmountException;
import Homework4.Exceptions.CustomerException;
import Homework4.Exceptions.ProductException;
import Homework4.Models.Customer;
import Homework4.Models.Gender;
import Homework4.Models.Holiday;
import Homework4.Models.Product;
import Homework4.Repository.CustomerRepository;
import Homework4.Repository.ProductRepository;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        ProductRepository productRepository = new ProductRepository();

        fillRandomValueInCustomerAndProduct(customerRepository, productRepository);

        System.out.println(customerRepository);
        System.out.println(productRepository);

        System.out.println("------------------------------------");

        BasketController[] basketControllers = fillBasketController(customerRepository);

        int sizeOperation = 2;
        Random random = new Random();

        while (sizeOperation > 0) {

            try {
                OrderController orderController = new OrderController(customerRepository, productRepository,
                        false);

                int randomBasketController = random.nextInt(basketControllers.length);

                try {
                    basketControllers[randomBasketController].addToBasket(orderController.getOrder());

                    System.out.println("Заказ добавлен");
                } catch (CustomerException e) {
                    System.out.println(e.getMessage());
                }
            } catch (AmountException e) {
                System.out.println(e.getMessage());
            } catch (ProductException e) {
                System.out.println(e.getMessage());
            }

            if (sizeOperation != 1) {
                System.out.println("----------------------");
            }

            sizeOperation--;
        }

        System.out.println("------------------------------------");
        printBasketControllers(basketControllers);

        Customer[] customers = {
                new Customer(1, "andrey", 20, "9"),
                new Customer(2, "olya", 19, "8")

        };

        customers[0].setGender(Gender.MAN);
        customers[1].setGender(Gender.WOMAN);

        congratulate(customers);
    }

    public static void fillRandomValueInCustomerAndProduct(CustomerRepository customerRepository,
                                                ProductRepository productRepository) {
        String[] nameCustomer = {"andrey", "katya", "olya"};
        int[] ageCustomer = {18, 20, 30, 25, 19, 26, 27, 40};
        String[] phoneNumberCustomer = {"9", "98", "99", "96", "95", "88"};
        String[] nameOfProduct = {"t-shirt", "trousers", "sweater", "spoon", "fork", "ladle", "mug", "cup"};
        Random random = new Random();

        int amountCustomer = 2;
        int amountProduct = 5;

        for (int i = 0; i < amountCustomer; i++) {
            int randomNameCustomer = random.nextInt(nameCustomer.length);
            int randomAgeCustomer = random.nextInt(ageCustomer.length);
            int randomPhoneNumberCustomer = random.nextInt(phoneNumberCustomer.length);

            customerRepository.addCustomer(
                    new Customer(i, nameCustomer[randomNameCustomer],
                            ageCustomer[randomAgeCustomer], phoneNumberCustomer[randomPhoneNumberCustomer])
            );
        }

        for (int i = 0; i < amountProduct; i++) {
            int randomNameOfProduct = random.nextInt(nameOfProduct.length);
            int minPrice = 10;
            int maxPrice = 7000;
            int randomPrice = random.nextInt(maxPrice - minPrice + 1) + minPrice;

            productRepository.addProduct(new Product(nameOfProduct[randomNameOfProduct], randomPrice));
        }
    }

    public static BasketController[] fillBasketController(CustomerRepository customerRepository) {
        BasketController[] basketControllers = new BasketController[customerRepository.getSize()];

        for (int i = 0; i < customerRepository.getSize(); i++) {
            basketControllers[i] = new BasketController(customerRepository.getCustomerById(i));
        }

        return basketControllers;
    }

    public static void printBasketControllers(BasketController[] basketControllers) {
        for (int i = 0; i < basketControllers.length; i++) {
            System.out.println(basketControllers[i].toString() + "\n");
        }
    }

    public static void congratulate(Customer[] customers) {
        Date date = new Date(2024, 1, 1);

        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getGender() == Gender.MAN && date.equals(Holiday.FEBRUARY_23.getDate())) {
                System.out.println("С 23 февраля!");
            } else if (customers[i].getGender() == Gender.WOMAN && date.equals(Holiday.MARCH_8.getDate())) {
                System.out.println("С 8 марта!");
            } else if (date.equals(Holiday.NEW_YEAR.getDate())) {
                System.out.println("С новым годом!");
            } else {
                System.out.println("Нет праздников.");
            }
        }
    }
}
