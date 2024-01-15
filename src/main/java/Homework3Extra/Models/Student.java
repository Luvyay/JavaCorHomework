package Homework3Extra.Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Student implements Comparable<Student> {
    private String name;
    private List<Double> grades;
    private String specialty;

    public Student(String name, List<Double> grades, String specialty) {
        this.name = name;
        this.grades = grades;
        this.specialty = specialty;
    }

    public Student(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        grades = createRandomGrades();
    }

    public Student(String name) {
        this.name = name;
        specialty = createRandomSpecialty();
        grades = createRandomGrades();
    }

    private List<Double> createRandomGrades() {
        Random random = new Random();
        int maxSize = 10;
        int minSize = 1;
        int sizeList = random.nextInt((maxSize - minSize) + 1) + minSize;
        List<Double> result = new ArrayList<>();

        for (int i = 0; i < sizeList; i++) {
            int minGrade = 2;
            int maxGrade = 5;
            result.add(random.nextInt((maxGrade - minGrade) + 1) + minGrade + 0.0);
        }

        return result;
    }

    private String createRandomSpecialty() {
        List<String> specialties = new ArrayList<>();
        Collections.addAll(specialties, "Информатика", "Математика", "Русский язык");
        Random random = new Random();

        return specialties.get(random.nextInt(specialties.size()));
    }

    public double getAverageGrade() {
        double sum = 0;

        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }

        return (double) Math.round(sum / grades.size() * 10) / 10;
    }

    public String getName() {
        return name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "Имя: " + name +
                "\nСпециальность: " + specialty +
                "; Оценки: " + grades +
                "\nСредний балл: " + getAverageGrade();
    }

    @Override
    public int compareTo(Student o) {
        return (int) Math.round(getAverageGrade() * 10) - (int) Math.round(o.getAverageGrade() * 10);
    }
}
