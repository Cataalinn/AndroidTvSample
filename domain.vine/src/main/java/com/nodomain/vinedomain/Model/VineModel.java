package com.nodomain.vinedomain.Model;

import com.nodomain.vinedomain.API.VineAPI;
import com.nodomain.vinedomain.Entity.Vine;
import com.nodomain.vinedomain.Entity.Vines;
import com.nodomain.vinedomain.Model.Interface.IVineModel;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain.Model
 */
public class VineModel implements IVineModel {

    private Observable<List<Vine>> mVineObservable;
    private Subscription mSubscription;

    public VineModel() {
        this.mVineObservable = Observable.empty();
        mSubscription = Subscriptions.empty();
    }

    @Override
    public Observable<List<Vine>> getVines(final VineAPI vineAPI, final Scheduler scheduler) {
        mVineObservable = Observable.create(new Observable.OnSubscribe<List<Vine>>() {
            @Override
            public void call(final Subscriber<? super List<Vine>> subscriber) {
                mSubscription = vineAPI.getVines().subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Vines>() {
                    @Override
                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onNext(Vines vines) {
                        if (vines.isSuccess) {
                            subscriber.onNext(vines.vinesData.vineList);
                        } else {
                            subscriber.onError(new Throwable(vines.errorMessage));
                        }
                    }
                });
            }
        });
        return mVineObservable;
    }

    @Override
    public void unSubscribe() {
        mSubscription.unsubscribe();
    }
}
