package org.spring.streamexamples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day21 {
    public static void main(String[] args) {
        //input=(A,B,C) (1,2,3,4,5)   OUTPUT=A1B2C345
        List<String> letters=List.of("A","B","C");
        List<Integer> num=List.of(1,2,3,4,5);

      String  list= IntStream.range(0, num.size())
                .mapToObj(i->i<letters.size() ? letters.get(i)+num.get(i): String.valueOf(num.get(i)))
                .collect(Collectors.joining());

        System.out.println(list);
    }
}
