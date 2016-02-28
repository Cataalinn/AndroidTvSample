package com.servicesample.androidtvsample;

import android.app.Application;
import android.content.Context;

import com.example.videocaching.HttpProxyCacheServer;

/**
 * Created by cflor on 28.02.2016.
 */
public class VineApplication extends Application {

    private HttpProxyCacheServer proxy;

    public static HttpProxyCacheServer getProxy(Context context) {
        VineApplication app = (VineApplication) context.getApplicationContext();
        return app.proxy == null ? (app.proxy = app.newProxy()) : app.proxy;
    }

    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer(this);
    }
}
