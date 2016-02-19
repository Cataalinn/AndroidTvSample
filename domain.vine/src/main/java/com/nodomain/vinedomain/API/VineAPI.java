package com.nodomain.vinedomain.API;

import com.nodomain.vinedomain.Entity.Vines;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain.API
 */
public interface VineAPI {
    @GET("/timelines/popular")
    Observable<Vines> getVines();
}
