package com.servicesample.androidtvsample.Dagger.Component;

import android.app.Activity;

import com.servicesample.androidtvsample.Dagger.Annotation.VineAnnotation;
import com.servicesample.androidtvsample.Dagger.Module.VineModule;
import com.servicesample.androidtvsample.Fragment.VinesFragment;

import dagger.Component;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.servicesample.androidtvsample.Dagger.Component
 */
@VineAnnotation
@Component(modules = {VineModule.class})
public interface IVineComponent {
    void inject(VinesFragment vinesFragment);
}
