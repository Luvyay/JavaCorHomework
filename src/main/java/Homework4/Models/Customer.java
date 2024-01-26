package Homework4.Models;

import lombok.Getter;
import lombok.Setter;

public class Customer implements Comparable<Customer> {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String surname;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    private Gender gender;

    public Customer(long id, String name, String lastName, String surname, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Customer(long id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.lastName = "";
        this.surname = "";
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        if (lastName.equals("") && surname.equals("")) {
            return String.format("id %d %s\n%d лет, номер телефона: %s",
                    id, name, age, phoneNumber);
        } else {
            return String.format("id %d %s %s %s\n%d лет, номер телефона: %s",
                    id, lastName, name, surname, age, phoneNumber);
        }
    }

    @Override
    public int compareTo(Customer o) {
        long response = id - o.getId();

        if (response == 0) {
            return  0;
        } else if (response > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
