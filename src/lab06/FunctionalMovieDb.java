package lab06;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by shenv on 4/20/2017.
 */
public class FunctionalMovieDb implements MovieDb{

    private final Map<Category, List<Movie>> database = new HashMap<>();

    @Override
    public void add(Set<Category> categories, String name, Integer yearReleased) {
        Movie movieToAdd = new Movie(categories, name, yearReleased);

        for (Category nextCategory : categories) {
            List<Movie> movies = database.getOrDefault(nextCategory, new LinkedList<>());
            movies.add(movieToAdd);
            database.put(nextCategory, movies);
        }
    }

    @Override
    public void add(Category category, String name, Integer yearReleased) {
        Set<Category> categories = new HashSet<>();
        categories.add(category);
        add(categories, name, yearReleased);
    }

    @Override
    public Movie findByName(String name) {
        AtomicReference<Movie> foundMovie = new AtomicReference<>();

        database.values().forEach(nextList -> nextList.forEach(nextMovie -> {
            if (nextMovie.getName().equals(name))
                foundMovie.set(nextMovie); }));

        return foundMovie.get();
    }

    @Override
    public List<String> findByCategory(Category category) {
        List<Movie> movies = database.getOrDefault(category, Collections.emptyList());
        List<String> movieTitles = new ArrayList<>();

        movies.forEach(movie -> movieTitles.add(movie.getName()));

        return movieTitles;
    }

    @Override
    public boolean delete(String name) {
        AtomicReference<Movie> foundMovie = new AtomicReference<>();

        database.values().forEach(nextList -> nextList.forEach(nextMovie -> {
            if (nextMovie.getName().equals(name)) {
                foundMovie.set(nextMovie);
                nextList.remove(nextMovie);
            }}));



        return foundMovie.get() != null;

    }
}
