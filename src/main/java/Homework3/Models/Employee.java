package Homework3.Models;

import java.util.Date;

public class Employee implements Comparable<Employee> {
    private String fio;
    private String jobTitle;
    private String numberOfPhone;
    private Double salary;
    private int age;
    private Date date;

    public Employee(String fio, String jobTitle, String numberOfPhone, Double salary, int age, Date date) {
        this.fio = fio;
        this.jobTitle = jobTitle;
        this.numberOfPhone = numberOfPhone;
        this.salary = salary;
        this.age = age;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(String numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник. ФИО: %s, должность: %s, номер телефона: %s,\n" +
                        "заработная плата: %f, возраст: %d\n", this.fio, this.jobTitle, this.numberOfPhone, this.salary,
                this.age);
    }

    public void printInfo() {
        System.out.println(String.format("Сотрудник. ФИО: %s; должность: %s; номер телефона: %s;\n" +
                        "заработная плата: %f; возраст: %d\n", this.fio, this.jobTitle, this.numberOfPhone, this.salary,
                this.age));
    }

    @Override
    public int compareTo(Employee o) {
        int firstDate = date.getYear() * 10000 + date.getMonth() * 100 + date.getDate();
        int secondDate = o.getDate().getYear() * 10000 + o.getDate().getMonth() * 100 + o.getDate().getDate();
        return firstDate - secondDate;
    }
}
