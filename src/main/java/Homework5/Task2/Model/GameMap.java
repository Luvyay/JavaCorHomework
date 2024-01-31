package Homework5.Task2.Model;


import Homework5.Task2.Exception.IncorrectArrayLenghtException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class GameMap {
    private int[] array;
    private String nameFile;
    private static final int MAXLENGTHARRAY = 9;

    public GameMap(int[] array, String nameFile) {
        this.array = array;
        this.nameFile = nameFile;
    }

    public String writeToFile() throws IOException {
        if (!(array.length > MAXLENGTHARRAY || array.length < MAXLENGTHARRAY)) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(nameFile)) {
                for (int i = 0; i < array.length; i += 3) {
                    int[] row = {array[i], array[i + 1], array[i + 2]};
                    fileOutputStream.write(encode(row));
                }
            }
        } else {
            throw new IncorrectArrayLenghtException(MAXLENGTHARRAY, array.length);
        }

        return String.format("Данные игры записаны в файл: %s", nameFile);
    }

    private int encode(int[] row) {
        int encodeValue = 0;

        for (int i = 0; i < row.length; i++) {
            encodeValue <<= 2;
            encodeValue |= row[i];
        }

        return encodeValue;
    }

    public String readFromFile() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(nameFile)) {
            for (int i = 0; i < array.length; i += 3) {
                int readValue = fileInputStream.read();

                int[] row = decode(readValue);
                array[i] = row[0];
                array[i+1] = row[1];
                array[i+2] = row[2];
            }
        }

        return String.format("Данные были считаны из файла: %s", nameFile);
    }

    private int[] decode(int readValue) {
        int[] response = new int[3];

        for (int i = response.length - 1; i >= 0; i--) {
            response[i] = readValue & 3;
            readValue >>= 2;
        }

        return response;
    }

    @Override
    public String toString() {
        return String.format(Arrays.toString(array));
    }
}
