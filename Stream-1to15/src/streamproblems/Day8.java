package streamproblems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Day8 {

    public static void main(String[] args) {

        //Find the shortest word from the list
        List<String> list= Arrays.asList("hello", "hi", "Good", "morning");
        List<String> shortest=list.stream().min(Comparator.comparing(String::length))
                .stream().collect(Collectors.toList());
        System.out.println(shortest);


        //find the shortest word from the string
        String str="Hi, Good morning how are you";
        String shortestword=Arrays.stream(str.split(" "))
                .min(Comparator.comparing(String::length)).orElse(null);
        System.out.println(shortestword);

        //Find the sum of digits
        int digits=24345;
        int sum=String.valueOf(digits).chars().map(c-> c-'0').sum();
        System.out.println(sum);

        //Factorial
        int i=5;
        int factorial= IntStream.rangeClosed(1,i).reduce(1,(a,b)->a*b);
        System.out.println(factorial);

        //second largest number
        List<Integer> num=Arrays.asList(1,2,3,4,5);
        int second=num.stream().sorted(Comparator.reverseOrder()).skip(1)
                .findFirst().orElse(0);
        System.out.println(second);
    }
}
