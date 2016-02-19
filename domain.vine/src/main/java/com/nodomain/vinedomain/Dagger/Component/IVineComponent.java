package com.nodomain.vinedomain.Dagger.Component;

import android.app.Activity;

import com.nodomain.vinedomain.Dagger.Annotation.VineAnnotation;
import com.nodomain.vinedomain.Dagger.Module.VineModule;

import dagger.Component;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain.Dagger.Component
 */
@VineAnnotation
@Component(modules = {VineModule.class})
public interface IVineComponent {
    void inject(Activity activity);

}
