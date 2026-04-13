package streamproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day3 {
    public static void main(String[] args) {

        //find the duplicates
        List<Integer> list = Arrays.asList(1,2,3,2,4,5,1);

        Set<Integer> duplicates = list.stream()
                .filter(e -> Collections.frequency(list, e) > 1)
                .collect(Collectors.toSet());
        System.out.println(duplicates);

        //find 2nd highest number
        int secondHighest = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println(secondHighest);

        //Word frequency using streams

        List<String> words = Arrays.asList("java","stream","java","api","code","stream");
        Map<String, Long> freq =
                words.stream()
                        .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(freq);

        //Partition Even and Odd Numbers
        Map<Boolean, List<Integer>> partition =
                list.stream()
                        .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partition);

        //Find Longest String
        String longest =
                words.stream()
                        .max(Comparator.comparing(String::length))
                        .orElse("");
        System.out.println(longest);

        //First Non-Repeating Character
        String str="Shweta";
        Character result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(result);

        /*//Flatten Nested Lists
        List<Integer> nestedList=Arrays.asList(1,2,3,4,5);
        List<Integer> flat =
                nestedList.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList());*/

        //Find Common Elements Between Lists
        List<Integer> list2=Arrays.asList(1,2,3,4,5);
        List<Integer> common =
                list.stream()
                        .filter(list2::contains)
                        .collect(Collectors.toList());
        System.out.println(common);

        //Skip and Limit Example
        List<Integer> skip=list.stream()
                .skip(2)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(skip);

        //Collect into Custom Collection
        LinkedList<Integer> linked =
                list.stream()
                        .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(linked);

         //Parallel Stream Use Case
        long count = list.parallelStream()
                .filter(n -> n % 2 == 0)
                .count();

        //Word frequency using streams
        String sentence = "java is java stream api";

        Map<String, Long> freq1 =
                Arrays.stream(sentence.split(" "))
                        .collect(Collectors.groupingBy(
                                word -> word,
                                Collectors.counting()));
        System.out.println(freq1);

        //Reduce vs Collect
        int sum = list.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);


        //Group and count elements
        Map<Integer, Long> count2 =
                list.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));
        System.out.println(count2);

        //Debug stream operations
        List<Integer> debug=list.stream()
                .peek(System.out::println)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(debug);

        //Check if a String is Palindrome
        String str3 = "madam";

        boolean isPalindrome = IntStream.range(0, str3.length() / 2)
                .allMatch(i -> str3.charAt(i) == str3.charAt(str3.length() - i - 1));

        System.out.println(isPalindrome);

        //Check Palindrome (Ignoring Case & Spaces)
        String str4 = "Madam In Eden Im Adam";

        String cleaned = str4.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome2 = IntStream.range(0, cleaned.length() / 2)
                .allMatch(i -> cleaned.charAt(i) == cleaned.charAt(cleaned.length() - i - 1));
        System.out.println(isPalindrome2);

        //Find All Palindrome Words in a List
        List<String> words1= Arrays.asList("madam", "java", "racecar", "hello");

        List<String> palindromes = words1.stream()
                .filter(word -> word.equals(
                        new StringBuilder(word).reverse().toString()))
                .collect(Collectors.toList());
        System.out.println(palindromes);

        //Count Palindrome Words
        long count3= words.stream()
                .filter(word -> word.equals(
                        new StringBuilder(word).reverse().toString()))
                .count();
        System.out.println(count3);
    }
}
