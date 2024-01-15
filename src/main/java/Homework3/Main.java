package Homework3;

import Homework3.Models.Employee;
import Homework3.Models.Supervisor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee ivan = new Employee("Ivanov Ivan Ivanovich", "developer", "1111",
                100.0, 25, new Date(2023, 03, 01));
        Employee olga = new Employee("Olgovna Olga Olgovich", "tester", "2222",
                150.0, 27, new Date(2022, 03, 01));
        Employee sergey = new Employee("Sergeev Sergey Sergeevich", "designer", "3333",
                200.0, 50, new Date(2023, 03, 01));
        Employee natalia = new Employee("Natalievna Natalia Natalievich", "analytics", "4444",
                250.0, 25, new Date(2023, 01, 01));
        Employee andrey = new Employee("Andreev Andrey Andreevich", "devops", "5555",
                300.0, 25, new Date(2024, 11, 01));
        Supervisor supervisor = new Supervisor("Andreev Andrey Andreevich", "supervisor", "5555",
                300.0, 25, new Date(2024, 11, 01));

        List<Employee> company = new ArrayList<>();

        company.add(ivan);
        company.add(olga);
        company.add(sergey);
        company.add(natalia);
        company.add(andrey);
        company.add(supervisor);

        for (Employee employee: company) {
            employee.printInfo();
        }

        System.out.println("Увеличиваем всем ЗП (кроме руководителя):");

        Supervisor.increaseSalary(company, 3000);

        for (Employee employee: company) {
            employee.printInfo();
        }
    }
}
