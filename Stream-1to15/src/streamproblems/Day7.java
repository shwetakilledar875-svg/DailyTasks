package streamproblems;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day7 {

    public static void main(String[] args) {


        // Convert a List of Strings to Uppercase
        List<String> words = List.of("hello", "world");
        List<String> uppercaseWords = words.stream().map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase Words: " + uppercaseWords);

        //Check if All Elements in a List Satisfy a Condition
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println("All Even: " + allEven);

        //Check if Any Element in a List Satisfies a Condition
        List<Integer> number = List.of(1, 2, 3, 4, 5);
        boolean anyEven = number.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Any Even: " + anyEven);

        //Find the Sum of Digits of a Number
        int digits = 12345;
        int sum = String.valueOf(digits).chars().map(Character::getNumericValue)
                .sum();
        System.out.println("Sum of Digits: " + sum);

        //Find the Factorial of a Number
        int fact = 5;
        int factorial = IntStream.rangeClosed(1, fact)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Factorial: " + factorial);
    }
}
