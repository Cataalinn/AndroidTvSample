package com.nodomain.rottentomatoesapi.Injector;

import android.app.Activity;
import android.app.Fragment;

import com.nodomain.rottentomatoesapi.Dagger.Component.DaggerIMovieComponent;
import com.nodomain.rottentomatoesapi.Dagger.Module.MovieModule;
import com.nodomain.rottentomatoesapi.Interface.IMovieCallBack;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Smart Mirror project
 */
public class RottenTomatoesInjector {
    public static void inject(Activity activity, IMovieCallBack movieCallBack){
        DaggerIMovieComponent.builder().movieModule(new MovieModule(movieCallBack)).build().inject(activity);
    }

    public static void inject(Fragment fragment, IMovieCallBack movieCallBack){
        DaggerIMovieComponent.builder().movieModule(new MovieModule(movieCallBack)).build().inject(fragment);
    }
}
