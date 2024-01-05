package Homework2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*
        1. Написать метод, возвращающий количество чётных элементов массива.
        countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
         */

//        int[] array1 = {2, 1, 2, 3, 4};
//        int[] array2 = {2, 2, 0};
//        int[] array3 = {1, 3, 5};
//
//        System.out.println(countEvens(array1));
//        System.out.println(countEvens(array2));
//        System.out.println(countEvens(array3));

        /*
        2. Написать функцию, возвращающую разницу между самым большим и
        самым ма- леньким элементами переданного не пустого массива.
         */

//        int[] array1 = {2, 1, 2, 3, 4};
//        int[] array2 = {2, 2, 0};
//        int[] array3 = {1, 3, 5};
//        int[] array4 = {};
//
//        try {
//            System.out.println(diffMaxAndMin(array1));
//            System.out.println(diffMaxAndMin(array2));
//            System.out.println(diffMaxAndMin(array3));
//            System.out.println(diffMaxAndMin(array4));
//        } catch (InvalidArrayException e) {
//            System.err.println("Ошибка: " + e.getMessage());;
//        }

        /*
        3. Написать функцию, возвращающую истину, если в переданном массиве
        есть два соседних элемента, с нулевым значением.
         */

        int[] array1 = {10, 0, 1};
        int[] array2 = {0, 0, 0};
        int[] array3 = {1, 0, 0};

        System.out.println(twoZeroNeighbors(array1));
        System.out.println(twoZeroNeighbors(array2));
        System.out.println(twoZeroNeighbors(array3));

    }

    public static int countEvens(int[] array) {
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result++;
            }
        }

        return result;
    }

    public static int diffMaxAndMin(int[] array) throws InvalidArrayException {
        if (array.length > 1) {
            int min = array[0];
            int max = array[0];

            for (int i=1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }

                if (array[i] > max) {
                    max = array[i];
                }
            }

            return max - min;
        } else {
            throw new InvalidArrayException("Длина массива должна быть больше 1.");
        }
    }

    public static boolean twoZeroNeighbors(int[] array) {
        boolean result = false;
        int sizeArrayForCheck = array.length - 1;

        for (int i=0; i < sizeArrayForCheck; i++) {
            if (array[i] == 0 && array[i+1] == 0) {
                result = true;
            }
        }

        return result;
    }
}
