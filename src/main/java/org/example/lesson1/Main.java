package org.example.lesson1;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        OptionalDouble average = numbers.stream().filter(n -> n % 2 == 0).mapToDouble(n -> n).average();

        if (average.isPresent()) {
            System.out.println("Среднее значение четных чисел: " + average.getAsDouble());
        } else {
            System.out.println("Четные числа отсутствуют.");
        }
    }
}
