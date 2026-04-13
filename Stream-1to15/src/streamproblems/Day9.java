package streamproblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day9 {
    public static void main(String[] args) {
        List<Emp> employees = List.of(
                new Emp("Amit", "IT", "Delhi", 60000),
                new Emp("Riya", "HR", "Delhi", 45000),
                new Emp("Karan", "IT", "Mumbai", 75000),
                new Emp("Sneha", "Finance", "Mumbai", 52000),
                new Emp("Arjun", "IT", "Delhi", 48000),
                new Emp("Meera", "Finance", "Mumbai", 80000)
        );

        Map<String, Map<String, Double>> map=employees.stream()
                .collect(Collectors.groupingBy(Emp::city,
                        Collectors.groupingBy(Emp::department,
                        Collectors.averagingInt(Emp::salary))));
        System.out.println(map);
    }
}
