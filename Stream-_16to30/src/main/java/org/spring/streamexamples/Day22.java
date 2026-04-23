package org.spring.streamexamples;

import java.util.*;
import java.util.stream.Collectors;

public class Day22 {

    public static void main(String[] args) {
        List<Movies> movie= Arrays.asList(
                new Movies("Inception", "Sci-Fi", 8.8, 2010, 148),
                new Movies("Interstellar", "Sci-Fi", 8.6, 2014, 169),
                new Movies("Titanic", "Romance", 7.8, 1997, 195),
                new Movies("The Dark Knight", "Action", 9.0, 2008, 152),
                new Movies("Avengers", "Action", 8.0, 2012, 143),
                new Movies("Notebook", "Romance", 7.5, 2004, 123),
                new Movies("Joker", "Drama", 8.4, 2019, 122),
                new Movies("Parasite", "Drama", 8.6, 2019, 132)
        );

        //Get all movie names
        List<String> movieName=movie
                .stream()
                .map(Movies::getName)
                .collect(Collectors.toList());
        System.out.println("Movie Names: "+movieName);

        //Filter movies with rating > 8
        List<Double> rating=movie.stream()
                .filter(r->r.getRating()>8)
                .map(Movies::getRating)
                .collect(Collectors.toList());
        System.out.println("Ratings > 8: "+rating);

        //Count number of movies in "Action" genre
        long movieGenre=movie.stream()
                .filter(m->m.getGenre()=="Action")
                .map(Movies::getName).count();
        System.out.println("Movie Gener of action : "+movieGenre);

        //Get list of movies released after 2010
        List<String> movieList=movie.stream()
                .filter(m->m.getYear()>2010)
                .map(Movies::getName)
                .collect(Collectors.toList());
        System.out.println("Movies released after 2010: "+movieList);

        //Find average rating of all movies
        double averageRatings=movie.stream()
                .mapToDouble(Movies::getRating)
                .average()
                .orElse(0.0);
        System.out.println("Average Ratings of all movies: "+averageRatings);

        //Sort movies by rating (descending)
        List<Movies> sortRating=movie.stream()
                .sorted(Comparator.comparing(Movies::getRating).reversed())
                .collect(Collectors.toList());
        System.out.println("Sort in descending order: "+sortRating);

        //Find the highest-rated movie
       String highestRated=movie.stream()
                .sorted(Comparator.comparing(Movies::getRating).reversed())
                .map(Movies::getName)
                .findFirst().orElse(null);
        System.out.println("Highest Rated Movie: "+highestRated);

        //Get all movie names in uppercase
        List<String> uppercase=movie.stream()
                .map(m->m.getName().toUpperCase())
                .toList();
        System.out.println("Movies names in uppercase: " +uppercase);

        //Group movies by genre
       Map<String, List<Movies>> grouping=movie.stream()
                .collect(Collectors.groupingBy(Movies::getGenre));
        System.out.println("Grouping movies by genre: "+grouping);

        //Find movies with duration > 150 minutes
        List<String> duration=movie.stream()
                .filter(m->m.getDuration() > 150)
                .map(Movies::getName)
                .collect(Collectors.toList());
        System.out.println(duration);

        //Get top 3 highest-rated movies
        Movies thirdHighest=movie.stream()
                .sorted(Comparator.comparing(Movies::getRating).reversed())
                .skip(2)
                .findFirst()
                .orElse(null);
        System.out.println("Third highest movie: "+thirdHighest);

        //Find the second highest-rated movie
        Movies secondHighest=movie.stream()
                .sorted(Comparator.comparing(Movies::getRating).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second Highest rated movie: "+secondHighest);

        //Find average rating per genre
        Map<String, Double> avergeRating=movie.stream()
                .collect(Collectors.groupingBy(Movies::getGenre,
                        Collectors.averagingDouble(Movies::getRating)));
        System.out.println(avergeRating);

        //Get a map: movie name → rating
        Map<String, Double> map=movie.stream()
                .collect(Collectors.toMap(Movies::getName,Movies::getRating));
        System.out.println(map);

        //Partition movies into rating > 8 and <= 8
        Map<Boolean, List<Movies>> partition=movie.stream()
                .collect(Collectors.partitioningBy(m->m.getRating() > 8));
        System.out.println(partition);

        //Find the longest movie in each genre
        Map<String, Optional<Movies>> longest=movie.stream()
                .collect(Collectors.groupingBy
                        (Movies::getGenre,
                        Collectors.maxBy(Comparator.comparing(Movies::getDuration))));
        System.out.println("Longest duration movie: "+longest);

        //Check if all movies have rating > 7
        boolean check=movie.stream()
                .allMatch(m->m.getRating() > 7);
        System.out.println("All moviews rating should be > 7: "+check);

        //Find first movie released after 2015
        Movies firstMovie=movie.stream()
                .filter(m->m.getYear()>2015)
                .sorted(Comparator.comparing(Movies::getName).reversed())
                .findFirst().orElse(null);
        System.out.println(firstMovie);

        //Find duplicate genres (if dataset grows)
        Set<String> duplicates=movie.stream()
                .collect(Collectors.groupingBy(Movies::getGenre, Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println(duplicates);

        //Sort movies by multiple fields (rating desc, then year asc)
        List<Movies> sorting=movie.stream()
                .sorted(Comparator.comparing(Movies::getRating).reversed()
                        .thenComparing(Movies::getYear))
                .toList();
        System.out.println("Sorted in multiple orders: "+sorting);
    }
}



