package streamproblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day6 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //find the sum of list
        int sum=list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //Partition
        Map<Boolean, List<Integer>> partititon=list.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println(partititon);

        //find duplicates
        List<String> words=Arrays.asList("hello","hello","hi","bye","hi");
        List<String> duplicates=words.stream().distinct().collect(Collectors.toList());
        System.out.println(duplicates);

        //Given a word, find the occurrence of Each Character
        String word="Shwetaae";
        Map<Character, Long> charOccurence=word.chars()
                .mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
        System.out.println(charOccurence);

        //square of numbers
        List<Integer> square=List.of(1, 2, 3, 4, 5);
        List<Integer> squares=square.stream().map(n->n*n).toList();
        System.out.println(squares);

        //find the sum of two numbers
        List<Integer> add=List.of(1, 2, 3, 4, 5,6,7,8,9);
        int target=10;
        List<String> twosum= IntStream.range(0,add.size()).boxed()
                .flatMap(i->IntStream.range(i+1, add.size())
                        .filter(j->add.get(i)+add.get(j)==target)
                        .mapToObj(j->add.get(i) + "," + add.get(j)))
                .collect(Collectors.toList());
        System.out.println(twosum);

        //Find average of numbers after sorting
        int[] numbers = {5, 10, 15, 20, 25, 30, 35, 40};
        double avg = Arrays.stream(numbers).sorted().average()
                .orElse(0);
        System.out.println(avg);

        //Find average using sum and count manually
        double avgerage = Arrays.stream(numbers).sum() /
                (double) Arrays.stream(numbers).count();
        System.out.println(avgerage);

        //Find average of top 3 highest numbers
        double third = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder())
                .limit(3).mapToInt(Integer::intValue)
                .average().orElse(0);
        System.out.println(third);

        //Find average of numbers whose square is greater than 400
        double four = Arrays.stream(numbers).filter(n -> n * n > 400)
                .average().orElse(0);
        System.out.println(four);
    }
}
