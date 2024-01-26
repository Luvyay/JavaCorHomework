package Homework4.Controller;

import Homework4.Exceptions.AmountException;
import Homework4.Exceptions.ProductException;
import Homework4.Models.Customer;
import Homework4.Models.Order;
import Homework4.Models.Product;
import Homework4.Models.RandomOrder;
import Homework4.Repository.CustomerRepository;
import Homework4.Repository.ProductRepository;


public class OrderController {
    private Order order;
    private boolean onlyCorrectProduct = true;

    public OrderController(Customer customer, Product product, int piece, boolean onlyCorrectProduct) {
        order = new Order(customer, product, piece);
        this.onlyCorrectProduct = onlyCorrectProduct;
    }

    public OrderController(Customer customer, Product product, int piece) {
        order = new Order(customer, product, piece);
    }

    public OrderController(CustomerRepository customerRepository, ProductRepository productRepository,
                           boolean onlyCorrectProduct) throws AmountException, ProductException {
        this.onlyCorrectProduct = onlyCorrectProduct;
        RandomOrder randomOrder = new RandomOrder();

        order = randomOrder.randomOrd(customerRepository, productRepository, this.onlyCorrectProduct);

        if (!isInArray(productRepository)) {
            throw new ProductException(order.getProduct());
        }

        int maxPiece = 100;

        if (order.getPiece() < 0 || order.getPiece() > maxPiece) {
            throw new AmountException(order.getPiece(), maxPiece);
        }
    }

    public boolean isInArray(ProductRepository productRepository) {
        boolean response = false;

        for (int i = 0; i < productRepository.getSize(); i++) {
            if (productRepository.getProductById(i).equals(order.getProduct())) {
                response = true;
            }
        }

        return response;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return order.toString();
    }
}
