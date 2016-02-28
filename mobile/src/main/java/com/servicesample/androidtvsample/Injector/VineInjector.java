package com.servicesample.androidtvsample.Injector;

import android.app.Activity;

import com.servicesample.androidtvsample.Dagger.Component.DaggerIVineComponent;
import com.servicesample.androidtvsample.Dagger.Module.VineModule;
import com.nodomain.vinedomain.Interface.IVineCallBack;
import com.servicesample.androidtvsample.Fragment.VinesFragment;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.servicesample.androidtvsample.Injector
 */
public class VineInjector {
    public static void inject(VinesFragment vinesFragment, IVineCallBack vineCallBack) {
        DaggerIVineComponent.builder().vineModule(new VineModule(vineCallBack)).build().inject(vinesFragment);
    }
}
