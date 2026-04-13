package streamproblems;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day12 {
    public static void main(String[] args) {

        //Find the Most Frequent Element in a List
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        String word=words.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
        System.out.println(word);

        //Find the Least Frequent Element in a List
        String least=words.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
        System.out.println(least);

        //Generate a List of Random Numbers Using Streams
        List<Integer> random= Stream.generate(()->new Random().nextInt(100)).limit(5)
                .toList();
        System.out.println(random);
    }
}
