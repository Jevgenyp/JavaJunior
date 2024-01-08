package org.example.lesson1;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

// 2. *Дополнительная задча: Переработать метод балансировки корзины товаров cardBalancing() с использованием Stream API

public class CardBalancing {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(10.0, 20.0, 30.0, 40.0, 50.0);

        cardBalancing(prices);
    }

    public static void cardBalancing(List<Double> prices) {
        double total = prices.stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        OptionalDouble average = prices.stream()
                .mapToDouble(Double::doubleValue)
                .average();

        if (average.isPresent()) {
            System.out.println("Средняя цена: " + average.getAsDouble());
            System.out.println("Товары с ценой выше средней: " +
                    prices.stream()
                            .filter(price -> price > average.getAsDouble())
                            .collect(Collectors.toList()));
            System.out.println("Товары с ценой ниже средней: " +
                    prices.stream()
                            .filter(price -> price < average.getAsDouble())
                            .collect(Collectors.toList()));
        } else {
            System.out.println("Товары в корзине отсутствуют.");
        }
    }
}
