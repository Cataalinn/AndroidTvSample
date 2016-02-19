package com.nodomain.vinedomain.Interface;

import com.nodomain.vinedomain.Entity.Vine;

import java.util.List;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain.Interface
 */
public interface IVineCallBack {
    void showProgress();

    void hideProgress();

    void onError(String message);

    void onResponse(List<Vine> vineList);
}
