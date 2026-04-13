package streamproblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day15 {
    static void main() {
        String str = "Programming";
        String sentence = "Honesty is best Policy, Honesty";
        //1. Remove duplicates from string and return in same order.
        String s = str.chars()
                .mapToObj(c->(char)c)
                .distinct()
                .map(String::valueOf)//collectors work only on stream of String
                .collect(Collectors.joining());
        System.out.println(s);


        //2. Find Longest word in a sentence
        Map<String ,Long>longest= Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(longest);

        //3. Reverse String
        String reverse = str.chars()
                .mapToObj(c->String.valueOf((char)c))
                .reduce("",(a,b)->b+a);
        System.out.println(reverse);


        List<String>fruits = List.of("grapes","oranges","apple","banana");


        //4. Sort a List of Strings in Alphabetical Order
        List<String> f1 = fruits.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("sorted list"+f1);

        //5.  Sort a List of Strings by Their Length
        List<String> f2 = fruits.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(f2);

        //6. find the longest String in a list
        String l = fruits.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println("longest:- "+l);

        //7. Find the Shortest String in a List
        String shortest = fruits.stream()
                .min(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println("Shortest string : "+shortest);

        //8. Group a List of Strings by Their Length
        Map<Integer,List<String>> mp = fruits.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(mp);

        //9. Find the Sum of Digits of a Number
        int number = 12345;
        int sum = String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
        System.out.println("sum "+sum);

        //10. Find the Factorial of a Number
        int no = 5;
        int factorial = IntStream.rangeClosed(1,no)
                .reduce(1,(a,b)->a*b);
        System.out.println("factorial "+factorial);

        //11. Partition a List of Integers into Even and Odd Numbers
        List<Integer> lst = List.of(2,3,4,5,8,10);
        List<Integer> lst1 = List.of(1,6,7,9,2,3);
        Map<Boolean,List<Integer>> partition = lst.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));

        System.out.println(partition);

        // 12.Merge Two Lists into a Single List
        List<Integer>list3 = Stream.concat(lst.stream(),lst1.stream())
                .collect(Collectors.toList());
        System.out.println(list3);

        //13. Merge Two Lists into a Single List and sorted in decreasing order
        List<Integer>list4 = Stream.concat(lst.stream(),lst1.stream())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(list4);

        //14. Find the Intersection of Two Lists
        List<Integer>intersection = lst.stream()
                .filter(lst1::contains)
                .collect(Collectors.toList());
        System.out.println(intersection);

        //15. Find the Union of Two Lists
        List<Integer> union = Stream.concat(lst.stream(),lst1.stream())
                .distinct().collect(Collectors.toList());
        System.out.println(union);

        //16. Find the Difference Between Two Lists
        List<Integer>difference = lst.stream()
                .filter(n->!lst1.contains(n))
                .collect(Collectors.toList());
        System.out.println(difference);

        //17. count the occurences of each element
        Map<Integer,Long> calFrequency = lst1.stream()
                .collect(Collectors.groupingBy(n->n,Collectors.counting()));
        System.out.println(calFrequency);

        //18. Count the Occurrences of Each Digit in a String
        String input = "hello 12233 world 456";
        Map<Character,Long> digitCount = input.chars()
                .mapToObj(c->(char)c)
                .filter(Character::isDigit)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println(digitCount);

        //19. Find the Most Frequent Element in a List
        List<String> words = List.of("apple","banana","orange","apple","orange","orange","banana","banana");
        String mostFrequent = words.stream()
                .collect(Collectors.groupingBy(p->p,Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println(mostFrequent);

        // 20. Find the Least Frequent Element in a List
        String leastFrequent = words.stream()
                .collect(Collectors.groupingBy(m->m,Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).get();
        System.out.println(leastFrequent);
    }
}


