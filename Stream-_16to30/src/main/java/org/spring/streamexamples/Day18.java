package org.spring.streamexamples;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day18 {

    public static void main(String[] args) {
        //1. Check if a String is a Palindrome
        String input = "local";
        boolean palindrome= IntStream.range(0, input.length()/2)
                .allMatch(i->input.charAt(i)==input.charAt(input.length()-1-i));
        System.out.println(palindrome);

        //2. Generate a List of Random Numbers Using Streams
        List<Integer> generate= Stream.generate(()->new Random().nextInt(50))
                .limit(5).toList();
        System.out.println(generate);

        //3. Flatten a List of Lists into a Single List
        List<List<String>> list=List.of(
                List.of("hi", "hello"),
                List.of("good","bad"),
                List.of("morning", "evening"));

        List<String> flatten=list.stream().flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flatten);

        //4. Find the Sum of All Even Numbers in a Nested List
        List<List<Integer>> even=List.of(List.of(21, 22, 23, 24, 25),
                List.of(31,32,33,34,35,36));
        List<Integer> evenList=even.stream()
                .flatMap(List::stream).filter(n->n % 2==0)
                .collect(Collectors.toList());
        System.out.println(evenList);

        //5. Find the First Repeated Character in a String
        String word = "hello";
        Character repeated=word.chars().mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()>1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println(repeated);

        //6. Find the First Non-Repeated Character in a String
        Character nonRepeated=word.chars().mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()==1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println(nonRepeated);

        //7. Find the Least Frequent Element in a List
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        String least=words.stream()
                .collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet().stream().min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
        System.out.println(least);

        //8. Find the Most Frequent Element in a List
        String most=words.stream()
                .collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
        System.out.println(most);
    }
}
