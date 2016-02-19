package com.nodomain.rottentomatoesapi.API;

import com.nodomain.rottentomatoesapi.Entity.Movies;
import com.nodomain.rottentomatoesapi.Manager.Constants;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
public interface MovieAPI {
    @GET("/api/public/v1.0/lists/movies/box_office.json?apikey=" + Constants.API_KEY)
    Observable<Movies> getBoxOfficeMovies();

    @GET("/api/public/v1.0/lists/movies/in_theaters.json?apikey=" + Constants.API_KEY)
    Observable<Movies> getInTheatersMovies();

    @GET("/api/public/v1.0/lists/movies/upcoming.json?apikey=" + Constants.API_KEY)
    Observable<Movies> getUpcomingMovies();

    @GET("/api/public/v1.0/movies.json?apikey=" + Constants.API_KEY)
    Observable<Movies> searchMovie(@Query("q") String query);
}
