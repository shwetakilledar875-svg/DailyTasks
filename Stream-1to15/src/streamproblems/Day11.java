package streamproblems;

import java.util.*;
import java.util.stream.Collectors;

public class Day11 {
    public static void main(String[] args) {
        String sentence="Have a Cup of Coffee";

        //reverse a sentence
        String reverse= Arrays.stream(sentence.split(" "))
                .reduce((w1, w2)->w2+" "+w1).orElse(null);
        System.out.println(reverse);

        //Convert to uppercase
        List<String> upper= Arrays.stream(sentence.split(" "))
                .map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upper);

        //Sort a List of Strings in Alphabetical Order
        List<String> order=Arrays.stream(sentence.split(" "))
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(order);

        //Sort a List of Strings by Their Length
        List<String> length=Arrays.stream(sentence.split(" "))
                .sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println("Sort a List of Strings by Their Length: "+length);

        //each occurence of word
        Map<String, Long> count=Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(w->w, Collectors.counting()));
        System.out.println("each occurence of word: "+count);

        //Find the Longest String in a List
        String longest=Arrays.stream(sentence.split(" "))
                .max(Comparator.comparing(String::length)).orElse(null);
        System.out.println("Longest word: "+longest);

        //Find the Shortest String in a List
        String shortest=Arrays.stream(sentence.split(" "))
                .min(Comparator.comparing(String::length)).orElse(null);
        System.out.println("Shortest word: "+shortest);

        //Group a List of Strings by Their Length
        Map<Integer, List<String>> groupLength=Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupLength);

        // Count the Occurrences of Each Vowel in a String
        Map<Character, Long> vowel=sentence.chars().mapToObj(c->(char) c)
                .filter(c->"aeiou".contains(String.valueOf(c)))
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
        System.out.println(vowel);





    }
}
