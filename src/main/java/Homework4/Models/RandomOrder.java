package Homework4.Models;

import Homework4.Repository.CustomerRepository;
import Homework4.Repository.ProductRepository;

import java.util.Random;

public class RandomOrder extends Random {
    public Order randomOrd(CustomerRepository customerRepository, ProductRepository productRepository,
                            boolean onlyCorrectProduct) {
        int minPiece = -10;
        int maxPiece = 200;
        int pieceRandom = nextInt(maxPiece - minPiece + 1) + minPiece;

        int randomCustomer = nextInt(customerRepository.getSize());
        int randomProduct = nextInt(productRepository.getSize());

        boolean isCorrectProduct;

        if (onlyCorrectProduct) {
            isCorrectProduct = true;
        } else {
            isCorrectProduct = nextBoolean();
        }

        if (isCorrectProduct) {
            return new Order(
                    customerRepository.getCustomerById(randomCustomer),
                    productRepository.getProductById(randomProduct), pieceRandom
            );
        } else {
            return new Order(
                    customerRepository.getCustomerById(randomCustomer),
                    new Product("crystal", 5000000), pieceRandom
            );
        }
    }
}
