package com.nodomain.vinedomain.Presenter;

import com.nodomain.vinedomain.API.VineAPI;
import com.nodomain.vinedomain.Entity.Vine;
import com.nodomain.vinedomain.Interface.IVineCallBack;
import com.nodomain.vinedomain.Model.Interface.IVineModel;
import com.nodomain.vinedomain.Presenter.Interface.IVinePresenter;

import java.util.List;

import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain.Presenter
 */
public class VinePresenter implements IVinePresenter {

    private IVineModel mIVineModel;
    private VineAPI mVineAPI;
    private IVineCallBack mIVineCallBack;
    private Subscription mSubscription;

    public VinePresenter(IVineModel mIVineModel, VineAPI mVineAPI, IVineCallBack mIVineCallBack) {
        this.mIVineModel = mIVineModel;
        this.mVineAPI = mVineAPI;
        this.mIVineCallBack = mIVineCallBack;
        this.mSubscription = Subscriptions.empty();
    }

    @Override
    public void getVines(Scheduler scheduler) {
        mIVineCallBack.showProgress();
        mSubscription = mIVineModel.getVines(mVineAPI, scheduler).subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Vine>>() {
            @Override
            public void onCompleted() {
                mIVineCallBack.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                mIVineCallBack.hideProgress();
                mIVineCallBack.onError(e.getMessage());
            }

            @Override
            public void onNext(List<Vine> vineList) {
                mIVineCallBack.onResponse(vineList);
            }
        });
    }

    @Override
    public void unSubscribe() {
        mSubscription.unsubscribe();
    }
}
