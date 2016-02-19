package com.servicesample.androidtvsample.Fragment.Adapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florescu George Cătălin on 17.02.2016.
 * Smart Mirror project
 */
public class MovieList {
    public static final String[] MOVIE_CATEGORY = {"Category one", "Category two", "Category tree", "Category four", "Category five", "Category six"};

    public static List<MovieAdapter> setupMovies() {
        List<MovieAdapter> movies = new ArrayList<>();
        for (int i = 0; i < 15 * 6; i++) {
            movies.add(new MovieAdapter());
        }

        return movies;
    }
}
