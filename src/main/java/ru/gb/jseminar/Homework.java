package ru.gb.jseminar;

//Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
// и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными.

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        System.out.println(ANSIConstants.ANSI_YELLOW_BACKGROUND+ANSIConstants.ANSI_BLACK+"СЧИТАЕМ ПРОИЗВЕДЕНИЕ: "+ANSIConstants.ANSI_RESET);
        Deque <Integer> deque1 = new ArrayDeque<>(Arrays.asList(5,2,1));
        System.out.println(ANSIConstants.ANSI_YELLOW+"Первое число в виде перевернутого списка: "+deque1+ANSIConstants.ANSI_RESET);
        Deque <Integer> deque2 = new ArrayDeque<>(Arrays.asList(2));
        System.out.println(ANSIConstants.ANSI_YELLOW+"Второе число в виде перевернутого списка: "+deque2+ANSIConstants.ANSI_RESET);
        Deque <Integer> multRes = hw.multiple(deque1, deque2);
        System.out.println("\033[0;1m"+ANSIConstants.ANSI_YELLOW+"Произведение в виде перевернутого списка: "+multRes+ANSIConstants.ANSI_RESET);
        System.out.println("");
        System.out.println(ANSIConstants.ANSI_BLUE_BACKGROUND+ANSIConstants.ANSI_BLACK+"СЧИТАЕМ СУММУ: "+ANSIConstants.ANSI_RESET);
        Deque <Integer> deque3 = new ArrayDeque<>(Arrays.asList(5,-2));
        System.out.println(ANSIConstants.ANSI_BLUE+"Первое число в виде перевернутого списка: "+deque3+ANSIConstants.ANSI_RESET);
        Deque <Integer> deque4 = new ArrayDeque<>(Arrays.asList(0,5));
        System.out.println(ANSIConstants.ANSI_BLUE+"Второе число в виде перевернутого списка: "+deque4+ANSIConstants.ANSI_RESET);
        Deque <Integer> sumRes = hw.sum(deque3, deque4);
        System.out.println("\033[0;1m"+ANSIConstants.ANSI_BLUE+"Сумма в виде перевернутого списка: "+sumRes+ANSIConstants.ANSI_RESET);
    }
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы!");
        }
        if (d1.size() > 1 && d2.size() > 1) {
            throw new Exception("Один из множителей должен быть однозначным!");
        }
        Deque <Integer> result = new ArrayDeque <>();
        int dozens = 0;
        int mult = 0;
        while (d1.size() > 0 || d2.size() > 0) {
            mult = 0;
            if(d1.size() > 0) {
                mult += d1.pollFirst();
            }
            if(d2.size() > 0) {
                mult = (mult * d2.peekFirst()) + dozens;
                dozens = 0;
            }
            if (mult >= 10){
                int toMinus = mult / 10;
                mult = mult - toMinus * 10;
                dozens = toMinus;
            }
            if (d1.size() == 0) {
                d2.pollFirst();
            }
            result.offer(mult);
        }
        if (dozens != 0) {
            result.offer(dozens);
        }
        return result;
    }
    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы!");
        }
        Deque<Integer> result = new ArrayDeque<>();
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < d1.size(); i++) {
            s1 = s1 + d1.pollLast();
            i--;
        }
        for (int i = 0; i < d2.size(); i++) {
            s2 = s2 + d2.pollLast();
            i--;
        }

        int resultInt = Integer.parseInt(s2) + Integer.parseInt(s1);
        do {
            int temp = resultInt % 10;
            result.offer(temp);
            resultInt = resultInt / 10;
        } while (resultInt != 0);
        return result;
    }
}
