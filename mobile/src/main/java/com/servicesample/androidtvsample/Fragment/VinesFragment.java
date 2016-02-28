package com.servicesample.androidtvsample.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.videocaching.VineCacheFileUtils;
import com.nodomain.vinedomain.Entity.Vine;
import com.nodomain.vinedomain.Interface.IVineCallBack;
import com.nodomain.vinedomain.Presenter.Interface.IVinePresenter;
import com.servicesample.androidtvsample.Dagger.Component.DaggerIVineComponent;
import com.servicesample.androidtvsample.Dagger.Module.VineModule;
import com.servicesample.androidtvsample.Fragment.Adapter.VineRecyclerView;
import com.servicesample.androidtvsample.Injector.VineInjector;
import com.servicesample.androidtvsample.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class VinesFragment extends Fragment implements IVineCallBack {

    @Bind(R.id.vineRecyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.progressbar)
    ProgressBar progressBar;

    @Bind(R.id.placeHolder)
    TextView placeHolder;

    @Inject
    IVinePresenter vinePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        VineInjector.inject(this, this);
        return inflater.inflate(R.layout.fragment_vines, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        vinePresenter.getVines(Schedulers.newThread());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        vinePresenter.unSubscribe();
        ButterKnife.unbind(this);
        VineCacheFileUtils.cleanDirectory(getActivity().getExternalCacheDir());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {
        placeHolder.setVisibility(View.VISIBLE);
        placeHolder.setText(message);
    }

    @Override
    public void onResponse(List<Vine> vineList) {
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new VineRecyclerView(getActivity(), vineList));
    }
}
