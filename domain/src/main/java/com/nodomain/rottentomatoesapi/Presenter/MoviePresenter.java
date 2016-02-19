package com.nodomain.rottentomatoesapi.Presenter;

import com.nodomain.rottentomatoesapi.API.MovieAPI;
import com.nodomain.rottentomatoesapi.Entity.Movie;
import com.nodomain.rottentomatoesapi.Interface.IMovieCallBack;
import com.nodomain.rottentomatoesapi.Model.Interface.IMoviesModel;
import com.nodomain.rottentomatoesapi.Presenter.Interface.IMoviePresenter;

import java.util.List;

import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
public class MoviePresenter implements IMoviePresenter {

    private MovieAPI mMovieAPI;
    private IMoviesModel mIMoviesModel;
    private IMovieCallBack mIMovieCallBack;
    private Subscription mSubscription;

    public MoviePresenter(MovieAPI movieAPI, IMoviesModel moviesModel, IMovieCallBack movieCallBack) {
        this.mMovieAPI = movieAPI;
        this.mIMoviesModel = moviesModel;
        this.mIMovieCallBack = movieCallBack;
        this.mSubscription = Subscriptions.empty();
    }

    @Override
    public void getBoxOfficeMovies(Scheduler scheduler) {
        mIMovieCallBack.showProgress();
        mSubscription = mIMoviesModel.getBoxOfficeMovies(mMovieAPI, scheduler).subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Movie>>() {
                    @Override
                    public void onCompleted() {
                        mIMovieCallBack.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mIMovieCallBack.hideProgress();
                        mIMovieCallBack.onError(e != null ? e.getMessage() : "Server error");
                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        mIMovieCallBack.onMoviesResponse(movies);
                    }
                });
    }

    @Override
    public void getInTheatersMovies(Scheduler scheduler) {
        mIMovieCallBack.showProgress();
        mSubscription = mIMoviesModel.getInTheatersMovies(mMovieAPI, scheduler).subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Movie>>() {
                    @Override
                    public void onCompleted() {
                        mIMovieCallBack.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mIMovieCallBack.hideProgress();
                        mIMovieCallBack.onError(e != null ? e.getMessage() : "Server error");
                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        mIMovieCallBack.onMoviesResponse(movies);
                    }
                });
    }

    @Override
    public void getUpcomingMovies(Scheduler scheduler) {
        mIMovieCallBack.showProgress();
        mSubscription = mIMoviesModel.getUpcomingMovies(mMovieAPI, scheduler).subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Movie>>() {
                    @Override
                    public void onCompleted() {
                        mIMovieCallBack.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mIMovieCallBack.hideProgress();
                        mIMovieCallBack.onError(e != null ? e.getMessage() : "Server error");
                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        mIMovieCallBack.onMoviesResponse(movies);
                    }
                });
    }

    @Override
    public void unSubscribe() {
        mSubscription.unsubscribe();
    }
}
