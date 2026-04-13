package streamproblems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day10 {
    public static void main(String[] args) {
        //find the product of the list
        List<Integer> numbers=List.of(1,3,3,3);
        int products=numbers.stream().reduce(1,(a,b)->a*b);
        System.out.println("product of numbers:"+products);

        //reverse the list in descending order
        List<Integer> decending=numbers.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("arrange in decending order "+ decending);

        //find the average of the list
        double average=  numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println(average);

        //Count the number of elements
        long count=numbers.stream().count();
        System.out.println("Count of list: "+count);

        //Check if a List Contains a Specific Element
        boolean contains=numbers.stream().anyMatch(n->n==8);
        System.out.println(contains);

        //Convert a List of Integers to Their Squares
        List<Integer> square=numbers.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println(square);

        // Find the First Element in a List
        int first=numbers.stream().skip(2).findFirst().orElse(0);
        System.out.println(first);

        //Check if All Elements in a List Satisfy a Condition
        boolean allOdd=numbers.stream().allMatch(n->n%2 !=0);
        System.out.println("All Odd: "+allOdd);

        // Find the Factorial of a Number
        int number=3;
        int factorial= IntStream.rangeClosed(1,number).reduce(1,(a,b)->a*b);
        System.out.println("Factorial: "+factorial);

        List<String> fruits=Arrays.asList("apple","orange","grapes","kiwi","mango");
        String reverse=fruits.stream().sorted()
                .reduce(" ",(a,b)->b+a);
        System.out.println(reverse);
    }
}
