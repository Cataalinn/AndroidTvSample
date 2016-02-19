package com.nodomain.rottentomatoesapi.Model;

import com.nodomain.rottentomatoesapi.API.MovieAPI;
import com.nodomain.rottentomatoesapi.Entity.Movie;
import com.nodomain.rottentomatoesapi.Entity.Movies;
import com.nodomain.rottentomatoesapi.Model.Interface.IMoviesModel;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
public class MoviesModel implements IMoviesModel {

    private Observable<List<Movie>> mMoviesObservable;
    private Subscription mSubscription;

    public MoviesModel() {
        mMoviesObservable = Observable.empty();
        mSubscription = Subscriptions.empty();
    }

    @Override
    public Observable<List<Movie>> getBoxOfficeMovies(final MovieAPI movieAPI, final Scheduler scheduler) {
        mMoviesObservable = Observable.create(new Observable.OnSubscribe<List<Movie>>() {
            @Override
            public void call(final Subscriber<? super List<Movie>> subscriber) {
                movieAPI.getBoxOfficeMovies().observeOn(AndroidSchedulers.mainThread()).subscribeOn(scheduler)
                        .subscribe(new Observer<Movies>() {
                            @Override
                            public void onCompleted() {
                                subscriber.onCompleted();
                            }

                            @Override
                            public void onError(Throwable e) {
                                subscriber.onError(e);
                            }

                            @Override
                            public void onNext(Movies movies) {
                                subscriber.onNext(movies.movies);
                            }
                        });
            }
        });

        return mMoviesObservable;
    }

    @Override
    public Observable<List<Movie>> getInTheatersMovies(final MovieAPI movieAPI, final Scheduler scheduler) {
        mMoviesObservable = Observable.create(new Observable.OnSubscribe<List<Movie>>() {
            @Override
            public void call(final Subscriber<? super List<Movie>> subscriber) {
                movieAPI.getInTheatersMovies().observeOn(AndroidSchedulers.mainThread()).subscribeOn(scheduler)
                        .subscribe(new Observer<Movies>() {
                            @Override
                            public void onCompleted() {
                                subscriber.onCompleted();
                            }

                            @Override
                            public void onError(Throwable e) {
                                subscriber.onError(e);
                            }

                            @Override
                            public void onNext(Movies movies) {
                                subscriber.onNext(movies.movies);
                            }
                        });
            }
        });

        return mMoviesObservable;
    }

    @Override
    public Observable<List<Movie>> getUpcomingMovies(final MovieAPI movieAPI, final Scheduler scheduler) {
        mMoviesObservable = Observable.create(new Observable.OnSubscribe<List<Movie>>() {
            @Override
            public void call(final Subscriber<? super List<Movie>> subscriber) {
                movieAPI.getUpcomingMovies().observeOn(AndroidSchedulers.mainThread()).subscribeOn(scheduler)
                        .subscribe(new Observer<Movies>() {
                            @Override
                            public void onCompleted() {
                                subscriber.onCompleted();
                            }

                            @Override
                            public void onError(Throwable e) {
                                subscriber.onError(e);
                            }

                            @Override
                            public void onNext(Movies movies) {
                                subscriber.onNext(movies.movies);
                            }
                        });
            }
        });

        return mMoviesObservable;
    }

    @Override
    public void unSubscribe() {
        mSubscription.unsubscribe();
    }
}
