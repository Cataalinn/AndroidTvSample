package com.nodomain.vinedomain.Model.Interface;

import com.nodomain.vinedomain.API.VineAPI;
import com.nodomain.vinedomain.Entity.Vine;

import java.util.List;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain.Model.Interface
 */
public interface IVineModel {
    Observable<List<Vine>> getVines(VineAPI vineAPI, Scheduler scheduler);

    void unSubscribe();
}
