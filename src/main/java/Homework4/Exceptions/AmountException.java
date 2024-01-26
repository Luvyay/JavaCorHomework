package Homework4.Exceptions;

public class AmountException extends Exception {
    private int currentAmount;
    private int maxAmount;

    public AmountException(int currentAmount, int maxAmount) {
        this.currentAmount = currentAmount;
        this.maxAmount = maxAmount;
    }

    @Override
    public String getMessage() {
        return String.format("Передано не корректное значение шт.:\n%s",
                (currentAmount < 0) ? "Число товаров не может быть отрицательным" :
                "Ожидаем < " + maxAmount + ", а вы передаете " + currentAmount);
    }
}
