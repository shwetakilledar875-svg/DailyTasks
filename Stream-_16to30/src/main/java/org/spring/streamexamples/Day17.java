package org.spring.streamexamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day17 {

    public static void main(String[] args) {
        List<String> strings =
                topKStudent(Arrays.asList(new StudentCourse(1, "Shweta", 50),
                new StudentCourse(2, "Bhoomika", 30),
                new StudentCourse(3, "Amulya", 40)), 3);
        System.out.println(strings);

    }
    public static List<String> topKStudent(List<StudentCourse> studentCourses, int k){
        List<String> list=studentCourses.stream().sorted(Comparator.comparing(StudentCourse::score)
                .reversed().thenComparing(StudentCourse::name))
                .map(StudentCourse::name).limit(k).collect(Collectors.toList());
       return list;
    }
}
record StudentCourse(int id, String name, int score){

}
