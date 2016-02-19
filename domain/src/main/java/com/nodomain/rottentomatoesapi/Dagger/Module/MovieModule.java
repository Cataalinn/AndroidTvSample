package com.nodomain.rottentomatoesapi.Dagger.Module;

import com.nodomain.rottentomatoesapi.API.MovieAPI;
import com.nodomain.rottentomatoesapi.Dagger.Annotation.MovieAnnotation;
import com.nodomain.rottentomatoesapi.Interface.IMovieCallBack;
import com.nodomain.rottentomatoesapi.Manager.Constants;
import com.nodomain.rottentomatoesapi.Model.Interface.IMoviesModel;
import com.nodomain.rottentomatoesapi.Model.MoviesModel;
import com.nodomain.rottentomatoesapi.Presenter.Interface.IMoviePresenter;
import com.nodomain.rottentomatoesapi.Presenter.MoviePresenter;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
@Module
public class MovieModule {

    private IMovieCallBack mIMovieCallBack;

    public MovieModule(IMovieCallBack mIMovieCallBack) {
        this.mIMovieCallBack = mIMovieCallBack;
    }

    @MovieAnnotation
    @Provides
    public IMovieCallBack provideIMovieCallBack() {
        return mIMovieCallBack;
    }

    @MovieAnnotation
    @Provides
    public IMoviesModel provideIMoviesModel() {
        return new MoviesModel();
    }

    @MovieAnnotation
    @Provides
    public IMoviePresenter provideIMoviePresenter(MovieAPI movieAPI, IMoviesModel moviesModel, IMovieCallBack movieCallBack) {
        return new MoviePresenter(movieAPI, moviesModel, movieCallBack);
    }

    @MovieAnnotation
    @Provides
    public MovieAPI provideMovieAPI() {
        long TIMEOUT = Constants.SERVER_TIME_OUT;

        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(TIMEOUT, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.SERVER_BASE_URL)
                .client(httpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(MovieAPI.class);
    }
}
