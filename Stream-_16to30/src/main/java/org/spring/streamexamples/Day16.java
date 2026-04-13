package org.spring.streamexamples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day16 {

    public static void main(String[] args) {
        //1.Find the First Non-Repeated Character in a String
        String word = "helloo";
        Character nonRepeated = word.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println(nonRepeated);

        //2.Find the First Repeated Character in a String
        Character repeated = word.chars().
                mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey).skip(1).findFirst().get();
        System.out.println(repeated);

        //3.Generate a List of Random Numbers Using Streams
        List<Integer> generate = Stream.generate(() -> new Random().nextInt(100))
                .limit(30).sorted().distinct().toList();
        System.out.println("Generate the random integers: " + generate);

        //4. Flatten a List of Lists into a Single List
        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );

        List<Integer> lists = listOfLists.stream().flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(lists);

        //5. Find the Sum of All Even Numbers in a Nested List
        int evenSum = listOfLists.stream().flatMap(List::stream)
                .filter(n -> n % 2 == 0)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of even numbers: " + evenSum);

        //6. Find the Sum of All Odd Numbers in a Nested List
        int oddSum = listOfLists.stream().flatMap(List::stream)
                .filter(n -> n % 2 != 0)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of odd numbers: " + oddSum);

        //7. Find the Longest Palindrome in a List of Strings
        List<String> words = List.of("madam", "racecar", "apple", "banana", "level");
        String palindrome=words.stream()
                .filter(w->w.equals(new StringBuilder(w).reverse().toString()))
                .max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println(palindrome);



    }
}

