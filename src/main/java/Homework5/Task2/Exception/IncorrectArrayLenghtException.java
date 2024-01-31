package Homework5.Task2.Exception;

public class IncorrectArrayLenghtException extends RuntimeException {
    private int correctLengthArray;
    private int currentLengthArray;

    public IncorrectArrayLenghtException(int correctLengthArray, int currentLengthArray) {
        this.correctLengthArray = correctLengthArray;
        this.currentLengthArray = currentLengthArray;
    }

    @Override
    public String getMessage() {
        return String.format("Некорректная длина массива. Ожидаем %d, а вы передаете %d.",
                correctLengthArray, currentLengthArray);
    }
}
