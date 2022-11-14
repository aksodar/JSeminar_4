package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    // Даны два Deque представляющие два целых числа. Цифры хранятся в обратном
    // порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5, 2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(4));
        Deque<Integer> d3 = new ArrayDeque<>(Arrays.asList(5, -2));
        Deque<Integer> d4 = new ArrayDeque<>(Arrays.asList(5));
        System.out.println(hw.multiple(d1, d2));
        System.out.println(hw.sum(d3, d4));
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public ArrayDeque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        int number = d1.peekFirst() * d2.peekFirst();
        int temp = 0;
        if (number > 9) {
            temp = number % 10;
            result.add(temp);
            number /= 10;
        }
        number = number + (d1.peekLast() * d2.peekLast());
        if (number > 9) {
            temp = number % 10;
            result.add(temp);
            number /= 10;
            result.add(number);
        }
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два
    // числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new ArrayDeque<>();

        int n1 = 0;
        int n2 = 0;

        Boolean negativ_flag_1 = false;
        Boolean negativ_flag_2 = false;
        while (!d1.isEmpty()) {
            if (d1.getLast() < 0) {
                n1 = 10 * n1 - d1.pollLast();
                negativ_flag_1 = true;
            } else {
                n1 = 10 * n1 + d1.pollLast();
            }
        }
        while (!d2.isEmpty()) {
            if (d2.getLast() < 0) {
                n2 = 10 * n2 - d2.pollLast();
                negativ_flag_2 = true;
            } else {
                n2 = 10 * n2 + d2.pollLast();
            }
        }
        if (negativ_flag_1) {
            n1 = -n1;
        }
        if (negativ_flag_2) {
            n2 = -n2;
        }
        int sum = n1 + n2;
        if (sum > 0) {
            do {
                result.add(sum % 10);
                sum /= 10;
            } while (sum > 0);
        } else {
            do {
                result.add(sum % 10);
                sum /= 10;
            } while (sum < 0);
        }
        return result;
    }
}
