package Homework3.Models;

import java.util.Date;
import java.util.List;

public class Supervisor extends Employee {
    public Supervisor(String fio, String jobTitle, String numberOfPhone, Double salary, int age, Date date) {
        super(fio, jobTitle, numberOfPhone, salary, age, date);
    }

    public static void increaseSalary(List<Employee> company, int allowance) {

        for (Employee employee: company) {
            if (!(employee instanceof Supervisor)) {
                employee.setSalary(employee.getSalary() + allowance);
            }
        }
    }
}
