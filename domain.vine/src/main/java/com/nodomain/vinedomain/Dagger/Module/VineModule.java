package com.nodomain.vinedomain.Dagger.Module;

import android.provider.SyncStateContract;

import com.nodomain.vinedomain.API.VineAPI;
import com.nodomain.vinedomain.Dagger.Annotation.VineAnnotation;
import com.nodomain.vinedomain.Interface.IVineCallBack;
import com.nodomain.vinedomain.Manager.Constants;
import com.nodomain.vinedomain.Model.Interface.IVineModel;
import com.nodomain.vinedomain.Model.VineModel;
import com.nodomain.vinedomain.Presenter.Interface.IVinePresenter;
import com.nodomain.vinedomain.Presenter.VinePresenter;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain.Dagger.Module
 */
@Module
public class VineModule {
    private IVineCallBack mIVineCallBack;

    public VineModule(IVineCallBack mIVineCallBack) {
        this.mIVineCallBack = mIVineCallBack;
    }

    @VineAnnotation
    @Provides
    public IVineCallBack provideIVineCallBack() {
        return this.mIVineCallBack;
    }

    @VineAnnotation
    @Provides
    public IVineModel provideIVineModel() {
        return new VineModel();
    }

    @VineAnnotation
    @Provides
    public IVinePresenter provideIVinePresenter(IVineModel mIVineModel, VineAPI mVineAPI, IVineCallBack mIVineCallBack) {
        return new VinePresenter(mIVineModel, mVineAPI, mIVineCallBack);
    }

    @VineAnnotation
    @Provides
    public VineAPI provideVineAPI() {
        long TIMEOUT = Constants.SERVER_TIME_OUT;

        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(TIMEOUT, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.SERVER_BASE_URL)
                .client(httpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(VineAPI.class);
    }

}
