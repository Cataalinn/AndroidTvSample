package com.nodomain.rottentomatoesapi.Model.Interface;

import com.nodomain.rottentomatoesapi.API.MovieAPI;
import com.nodomain.rottentomatoesapi.Entity.Movie;

import java.util.List;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
public interface IMoviesModel {
    Observable<List<Movie>> getBoxOfficeMovies(MovieAPI movieAPI, Scheduler scheduler);

    Observable<List<Movie>> getInTheatersMovies(MovieAPI movieAPI, Scheduler scheduler);

    Observable<List<Movie>> getUpcomingMovies(MovieAPI movieAPI, Scheduler scheduler);

    void unSubscribe();
}
