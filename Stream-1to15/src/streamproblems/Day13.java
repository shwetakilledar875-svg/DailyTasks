package streamproblems;

import java.util.List;
import java.util.*;
import java.time.LocalDate;
import java.util.stream.*;

record Person(String name, int age, String gender, LocalDate date, String city){
}

public class Day13 {

    static List<Person> person = List.of(
                new Person("Alice", 22, "Female", LocalDate.of(2002, 4, 12), "Delhi"),
                new Person("Bob", 35, "Male", LocalDate.of(1989, 1, 3), "Mumbai"),
                new Person("Charlie", 17, "Male", LocalDate.of(2007, 6, 8), "Delhi"),
                new Person("Diana", 29, "Female", LocalDate.of(1995, 9, 21), "Bangalore"),
                new Person("Eva", 42, "Female", LocalDate.of(1982, 3, 15), "Kolkata"),
                new Person("Frank", 55, "Male", LocalDate.of(1969, 10, 5), "Mumbai")
        );
        public void filterByCity(){
            List<String> p = person.stream()
                    .filter(e -> e.city() == "Delhi")
                    .map(Person::name)
                    .collect(Collectors.toList());
            System.out.println(p);
        }

        public void filterAllPeopleByAge(){

            List<String> p=  person.stream()
                    .filter(e->e.age() > 30)
                    .map(Person::name)
                    .collect(Collectors.toList());
            System.out.println(p);
        }

        public void countPersonBelow18(){

            Long count = person.stream()
                    .filter(e->e.age()<18)
                    .count();
            System.out.println(count);
        }

        public void firstPersonNameStartsA(){

        }

        public void checkPersonOlderThan60(){
            boolean check=person.stream()
                    .anyMatch(e->e.age()==60);
            System.out.println(check);
        }

        public void changeNameInUppercase(){
            List<String>name=person.stream()
                    .map(Person::name)
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
            System.out.println(name);
        }

        public void getLengthOfPeople(){
            List<String>ls = person.stream()
                    .map(Person::name)
                    .filter(n->n.length()>5)
                    .collect(Collectors.toList());
            System.out.println(ls);
        }

        public void sortPeopleByAgeAscending(){
            List<Person> ls = person.stream()
                    .sorted(Comparator.comparingInt(Person::age))
                    .collect(Collectors.toList());
            System.out.println(ls);
        }

        public void listAllUniqueCities(){
            List<String> list = person.stream()
                    .map(Person::city)
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(list);
        }

        public void checkAllPeople(){
            boolean check = person.stream()
                    .map(Person::age)
                    .anyMatch(n->n>10);
            System.out.println(check);
        }
}



