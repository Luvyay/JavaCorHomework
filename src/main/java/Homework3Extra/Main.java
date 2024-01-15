package Homework3Extra;

import Homework3Extra.Models.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> university = new ArrayList<>();

        Collections.addAll(university, new Student("Jack", "Информатика"),
                new Student("Sara", "Информатика"), new Student("Patrick", "Информатика"),
                new Student("Anton", "Информатика"), new Student("Piter", "Информатика"),
                new Student("Konor", "Информатика"), new Student("Jasmin"),
                new Student("Mat"), new Student("Steeve"),
                new Student("Alex"), new Student("Djo"),
                new Student("Djosh"));

        for (Student student: university) {
            System.out.println(student.toString());
        }

        System.out.println("---------------------------------");

        firstFiveStudent(university);
    }

    public static void firstFiveStudent(List<Student> university) {
        university.stream()
                .filter(student -> student.getSpecialty().equals("Информатика"))
                .sorted(Comparator.reverseOrder())
                .map(Student::getName)
                .limit(5)
                .forEach(System.out::println);
    }
}
