package Homework5.Task2;

import Homework5.Task2.Model.GameMap;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 3, 3, 3, 3, 3, 3, 3, 3};

        GameMap gameMap = new GameMap(array, "text.txt");

        try {
            System.out.println(gameMap.writeToFile());
            System.out.println(gameMap.readFromFile());
            System.out.println(gameMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
