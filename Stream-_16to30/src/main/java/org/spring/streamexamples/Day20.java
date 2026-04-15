package org.spring.streamexamples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day20 {

    public static void main(String[] args) {

        //Merge two lists and remove duplicates.
        List<Integer> l1= Arrays.asList(1,2,3,4,5,6);
        List<Integer> l2=Arrays.asList(5,6,7,2,3,4);
        List<Integer> merge= Stream
                .concat(l1.stream(), l2.stream()).distinct()
                .collect(Collectors.toList());
        System.out.println(merge);

        //Given a list of integers, find all elements that appear more than once.
     List<Integer> list=List.of(1,3,4,6,8,9,3,4,2,3,3,5);
       Set<Integer> appear=list.stream()
                .filter(i-> Collections.frequency(list, i)>1)
                .collect(Collectors.toSet());

        System.out.println(appear);

        //Find the top 3 highest numbers from a list.
        int highest=list.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .skip(2)
                .findFirst().get();
        System.out.println(highest);

        //Convert a list of strings into a map where key = string and value = length, handling duplicate keys.
        List<String> names=List.of("hello", "Good","hi");
        Map<String, Integer> convert=names.stream()
                .collect(Collectors.toMap(s->s,
                s->s.length(), (oldval, newval)->oldval));
        System.out.println(convert);

        //Remove null and empty strings from a list.
        List<String> random=Arrays.asList("hello", "Good",null, "hi", " ");
        List<String> remove=random.stream()
                .filter(s->s != null && !s.trim().isEmpty())
                .collect(Collectors.toList());
        System.out.println(remove);

    }
}
