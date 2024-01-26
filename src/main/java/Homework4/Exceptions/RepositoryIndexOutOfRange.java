package Homework4.Exceptions;

public class RepositoryIndexOutOfRange extends RuntimeException {
    private int currentIndex;
    private int maxIndex;

    public RepositoryIndexOutOfRange(int currentIndex, int maxIndex) {
        this.currentIndex = currentIndex;
        this.maxIndex = maxIndex;
    }

    @Override
    public String getMessage() {
        return String.format("Индекс выходит за диапазон. Передаете %d, а ожидаем < %d.",
                currentIndex, maxIndex);
    }
}
