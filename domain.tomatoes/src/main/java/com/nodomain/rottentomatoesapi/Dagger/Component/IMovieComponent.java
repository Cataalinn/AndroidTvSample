package com.nodomain.rottentomatoesapi.Dagger.Component;

import android.app.Activity;
import android.app.Fragment;

import com.nodomain.rottentomatoesapi.Dagger.Module.MovieModule;

import dagger.Component;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
@Component(modules = {MovieModule.class})
public interface IMovieComponent {
    void inject(Activity activity);

    void inject(Fragment fragment);
}
