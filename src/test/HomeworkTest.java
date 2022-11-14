package ru.gb.jseminar;

 import org.junit.jupiter.api.Assertions;

 import java.util.ArrayDeque;
 import java.util.Arrays;
 import java.util.Deque;
 import java.util.List;

 import static org.junit.jupiter.api.Assertions.*;

 class HomeworkTest {

     @org.junit.jupiter.api.Test
     void multipleText() {
         Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(0, 0, 1));

         Deque<Integer> actual = new Homework().multiple(new ArrayDeque<>(Arrays.asList(5, 2)),
                 new ArrayDeque<>(List.of(4)));

         Assertions.assertIterableEquals(expected, actual);
     }

     @org.junit.jupiter.api.Test
     void sumText() {
         Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(0, -2));

         Deque<Integer> actual = new Homework().sum(new ArrayDeque<>(Arrays.asList(5, -2)),
                 new ArrayDeque<>(List.of(5)));

         Assertions.assertIterableEquals(expected, actual);
     }
 }
