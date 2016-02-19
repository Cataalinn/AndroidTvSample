package com.nodomain.rottentomatoesapi.Interface;

import com.nodomain.rottentomatoesapi.Entity.Movie;

import java.util.List;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
public interface IMovieCallBack {
    void showProgress();

    void hideProgress();

    void onError(String errorMessage);

    void onMoviesResponse(List<Movie> movieList);
}
