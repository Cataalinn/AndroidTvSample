package com.nodomain.rottentomatoesapi.Presenter.Interface;

import rx.Scheduler;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
public interface IMoviePresenter {
    void getBoxOfficeMovies(Scheduler scheduler);

    void getInTheatersMovies(Scheduler scheduler);

    void getUpcomingMovies(Scheduler scheduler);

    void unSubscribe();
}
