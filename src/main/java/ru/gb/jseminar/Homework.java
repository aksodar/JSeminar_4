package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {

        Deque<Integer> num_mul_1 = new ArrayDeque<>(Arrays.asList(2, 1, 2, 5, 6));
        Deque<Integer> num_mul_2 = new ArrayDeque<>(Arrays.asList(2, 1, 3, 5));

        Deque<Integer> num_sum_1 = new ArrayDeque<>(Arrays.asList(2, -1));
        Deque<Integer> num_sum_2 = new ArrayDeque<>(Arrays.asList(4, -2));

        Logger log = Logger.getLogger(Homework.class.getName());
        Homework homework = new Homework();

        log.info(String.valueOf(homework.multiple(num_mul_1, num_mul_2)));
        log.info(String.valueOf(homework.sum(num_sum_1, num_sum_2)));

    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){

        Deque<Integer> result = new ArrayDeque<>();
        int n1 = 0;
        int n2 = 0;

        while (!d1.isEmpty()) {
            n1 = 10 * n1 + d1.pollLast();
        }
        while (!d2.isEmpty()) {
            n2 = 10 * n2 + d2.pollLast();
        }

        int mul = n1 * n2;

        do{
            result.add(mul % 10);
            mul /= 10;
        } while  (mul > 0);

        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){

        Deque<Integer> result = new ArrayDeque<>();

        int n1 = 0;
        int n2 = 0;

        Boolean negativ_flag_1 = false;
        Boolean negativ_flag_2 = false;

        while (!d1.isEmpty()) {
            if (d1.getLast() < 0){
                n1 = 10 * n1 - d1.pollLast();
                negativ_flag_1 = true;
            }
            else {
                n1 = 10 * n1 + d1.pollLast();
            }

        }

        while (!d2.isEmpty()) {
            if (d2.getLast() < 0){
                n2 = 10 * n2 - d2.pollLast();
                negativ_flag_2 = true;
            }
            else {
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
            do{
                result.add(sum % 10);
                sum /= 10;
            } while  (sum > 0);
        } else {
            do{
                result.add(sum % 10);
                sum /= 10;
            } while  (sum < 0);
        }


        return result;
    }
}