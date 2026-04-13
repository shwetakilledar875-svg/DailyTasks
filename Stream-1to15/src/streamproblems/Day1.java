package streamproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day1 {
    public static void main(String[] args){
        List<Integer> list= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //find the sum of list
        int sum=list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //find the sum even numbers
        int even=list.stream().filter(n->n%2 ==0).reduce(0,(a,b)->a+b);
        System.out.println(even);

        //find the sum odd numbers
        int odd=list.stream().filter(n->n%2 !=0).reduce(0,(a,b)->a+b);
        System.out.println(odd);

        /// /find the product of a even numbers
        int product=list.stream().filter(n->n%2 !=0).reduce(1,(a,b)->a*b);
        System.out.println(product);

        //Partition the even and odd
        Map<Boolean, List<Integer>> partititon=list.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println(partititon);

        //remove the duplicates from a String
        List<String> words=Arrays.asList("hello","hello","hi","bye","hi");
        List<String> duplicates=words.stream().distinct().collect(Collectors.toList());
        System.out.println(duplicates);

        //Given a sentence find the word that has the highest length.
        String sentence="I am currently working in Epam";
        String highest=Arrays.stream(sentence.split(" "))
                .max(Comparator.comparing(String::length)).orElse(null);
        System.out.println(highest);

        //Given a sentence find the word that has the 2nd (Nth) highest length
        String highest2=Arrays.stream(sentence.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(2).findFirst().orElse(null);
        System.out.println(highest2);

        //Find the length of the longest word
        int map=Arrays
                .stream(sentence.split(" "))
                .mapToInt(String::length).max().orElse(0);
        System.out.println("Currently = "+map);

        //Given a sentence, find the number of occurrence of each word
        Map<String, Long> eachOccurenece=Arrays
                .stream(sentence.split(" "))
                .collect(Collectors.groupingBy(w->w, Collectors.counting()));
        System.out.println(eachOccurenece);

        //Given a word, find the occurrence of Each Character
        String word="Shwetaae";
        Map<Character, Long> charOccurence=word.chars()
                .mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
        System.out.println(charOccurence);

        //Given a string combination with letters and special characters ,
        // reverse only alphabets and special characters should be in the same place
        String word1="ab$c";
        Deque<Character> reverse=word1.chars().mapToObj(c->(char) c)
                .filter(Character::isLetter)
                .collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println(reverse);

        //write a method to find the first non-repeated character
        // in a string using Java 8 streams:
         Optional<Character> nonreapeadted=word.chars().mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()))
                 .entrySet().stream().filter(e->e.getValue()==1).map(Map.Entry::getKey)
                 .skip(3).findFirst();
        System.out.println(nonreapeadted);

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

        List<String> frequencies=Arrays.asList("10","10","20","100","40","50","60","70","80","90","100");
        Map.Entry<String, Long> frequency=frequencies.stream()
                .collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .findFirst()
                .orElse(null);
        System.out.println(frequency);

        //reverse a string
        String[] array={"Banana","Orange","Apple", "Mango"};
        String[] wordss=Arrays.asList(array).reversed().toArray(new String[0]);
        System.out.println(Arrays.toString(wordss));


        int high=add.stream().sorted(Comparator.reverseOrder()).skip(3).findFirst().get();
        System.out.println(high);

        // Binary array contains all 0s and 1s, move all zeroes to left using Java 8
        List<Integer> number2=Arrays.asList(1, 0, 1,0 ,1,0,0,1);
        Map<Boolean, List<Integer>> binary=number2.stream()
                .collect(Collectors.partitioningBy(x->x==1));

        System.out.println(binary);


        String s1="hello world hello world";
        String str2=s1.chars().distinct()
                .mapToObj(c->String.valueOf((char) c)).collect(Collectors.joining());
        System.out.println(str2);

        //find all non duplicate integers using Java streams:
        List<String> nonduplicates=Arrays.asList("as", "123", "32", "2as");
        List<Integer> array1= nonduplicates.stream()
                .filter(s->s.matches("\\d+"))
                .map(Integer::parseInt)
                .distinct()
                .toList();
        System.out.println(array1);

        //Convert list to map with duplicates
        Map<String, Integer> listtomap=words.stream()
                .collect(Collectors.toMap(s->s, String::length, (existing, replacement) -> replacement));
        System.out.println(listtomap);

        //Flatten nested list
       List< List<String>> listts=Arrays.asList(Arrays.asList("hi","hoe","arew","you"),
                Arrays.asList("hello", "bye"),
                Arrays.asList("hi","Bye","good"));

       List<String> nested=listts.stream().flatMap(List::stream).collect(Collectors.toList());
       System.out.println(nested);

       //generate the random integer
        Random random=new Random();
        List<Integer> randoms=Stream
                .generate(()->random.nextInt(100))
                        .limit(20).collect(Collectors.toList());
        System.out.println(randoms);

        List<Integer> numbers = Arrays.asList(0, 1, 0, 0, 1, 1, 1, 1, 0, 1);
        Integer[] arraylist =
                numbers
                        .stream()
                        .collect(Collectors.collectingAndThen(Collectors.partitioningBy(i -> i == 0),
                                booleanListMap -> {
                                    return Stream.concat(booleanListMap.get(true).stream(), booleanListMap.get(false).stream())
                                            .toArray(Integer[]::new);
                                }));
        System.out.println(Arrays.toString(arraylist));





    }
}
