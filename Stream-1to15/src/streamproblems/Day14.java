package streamproblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day14 {
    List<String> ls = List.of("apple",
            "banana","apple","grapes",
            "oranges","apple","mango","grapes");

    String input = "hello";

    //1.
    public void countOccurrences(){
        Map<String,Long> mp =  ls.stream()
                .collect(Collectors.groupingBy(n->n,Collectors.counting()));
        System.out.println(mp);

    }

    //2.
    public void countOccurrencesOfCharacter(){
        Map<Character,Long> count = input.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(n->n,Collectors.counting()));
        System.out.println(count);
    }

    //3.
    String word = "welcome shweta to beautiful city Hyderabad";
    public void countWord() {
        Map<String, Long> w = Arrays.stream(word.split(" "))
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println(w);
    }

    // 4.
    public void countOccurrencesOfVowel(){
        Map<Character,Long> mp = word.chars()
                .mapToObj(n->(char)n)
                .filter(c->"aeiou".contains(String.valueOf(c)))
                .collect(Collectors.groupingBy(p->p,Collectors.counting()));
        System.out.println(mp);
    }

    //5.
    String digit = "hello 123 723 world 123";
    public void CountDigit() {
        Map<Character, Long> c = digit.chars()
                .mapToObj(n ->(char) n)
                .filter(Character::isDigit)
                .collect(Collectors.groupingBy(n->n,Collectors.counting()));
        System.out.println(c);

    }

    //6.
    public void reverseList(){
        List<Integer> lst = List.of(1,2,3,4,5);
        List<Integer> ls = lst.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list->{
                            Collections.reverse(list);
                            return list;
                        }
                ));
    //7.
        IntStream.range(0,lst.size())
                .mapToObj(i->lst.get(lst.size()-1-i))
                .collect(Collectors.toList());

        //8.
        List<Integer> reversed = IntStream.range(0, lst.size())
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(lst::get)
                .collect(Collectors.toList());

        System.out.println(ls);
    }
}


