package com.nodomain.vinedomain.Presenter.Interface;

import rx.Scheduler;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain.Presenter.Interface
 */
public interface IVinePresenter {
    void getVines(Scheduler scheduler);

    void unSubscribe();
}
