package com.nodomain.vinedomain.Injector;

import android.app.Activity;

import com.nodomain.vinedomain.Dagger.Component.DaggerIVineComponent;
import com.nodomain.vinedomain.Dagger.Module.VineModule;
import com.nodomain.vinedomain.Interface.IVineCallBack;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain.Injector
 */
public class VineInjector {
    public static void inject(Activity activity, IVineCallBack vineCallBack) {
        DaggerIVineComponent.builder().vineModule(new VineModule(vineCallBack)).build().inject(activity);
    }
}
