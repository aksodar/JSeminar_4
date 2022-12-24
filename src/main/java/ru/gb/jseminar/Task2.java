//Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', определите,
// является ли входная строка логически правильной.

package ru.gb.jseminar;

import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        String myBracketsString = "(()([{{}}{}])){()}";
        System.out.println("Дана строка: "+myBracketsString);
        Task2 newObj = new Task2();
        Deque<String> myDeque = new ArrayDeque<>(List.of(myBracketsString.split("")));
        if (newObj.validate(myDeque)) {
            System.out.println(ANSIConstants.ANSI_GREEN+"Логика скобок соблюдена!"+ANSIConstants.ANSI_RESET);
        } else
            System.out.println(ANSIConstants.ANSI_RED+"Неверная логика скобок!"+ANSIConstants.ANSI_RESET);
    }

    public boolean validate(Deque<String> deque) {
        if (deque.size() % 2 != 0) return false;
        Map<String, String> revise = new HashMap<>();
        revise.put("(", ")");
        revise.put("[", "]");
        revise.put("{", "}");
        Deque <String> toStore = new ArrayDeque <>();
        while (deque.size() > 0) {
            if (revise.containsKey(deque.peekFirst())) {
                String heap = deque.pollFirst();
                toStore.offerLast(heap);
            }
            else {
                if (revise.get(toStore.peekLast()).equals(deque.pollFirst())) {
                    toStore.pollLast();
                }
                else return false;
            }
        }
        return true;
    }
}