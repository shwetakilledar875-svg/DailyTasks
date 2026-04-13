package org.spring.streamexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day19 {
    public static void main(String[] args) {
        //find max frequency of number from the given array
        int[] list={1,2,2,3,3,3,1,5,6};
        long frequency= Arrays.stream(list).boxed()
                .collect(Collectors.groupingBy(lt->lt, Collectors.counting()))
                .values().stream().max(Long::compare).get();
        System.out.println(frequency);

        //find the number with frequency
        List<Integer> list2=Arrays.asList(1,2,2,3,3,3,1,5,6);
        Map<Integer, Long> maxfre=list2.stream().collect(Collectors.groupingBy(
                lt->lt, Collectors.counting()));
        System.out.println(maxfre);
    }
}
