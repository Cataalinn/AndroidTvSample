package com.servicesample.androidtvsample.Fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v17.leanback.app.BackgroundManager;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import com.servicesample.androidtvsample.Fragment.Adapter.GridItemPresenter;
import com.servicesample.androidtvsample.Fragment.Adapter.MovieAdapter;
import com.servicesample.androidtvsample.Fragment.Adapter.MovieCardPresenter;
import com.servicesample.androidtvsample.Fragment.Adapter.MovieList;
import com.servicesample.androidtvsample.Fragment.Presenter.IconHeaderItemPresenter;
import com.servicesample.androidtvsample.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Florescu George Cătălin on 17.02.2016.
 * Smart Mirror project
 */
public class MainTvFragment extends BrowseFragment {

    private static final int NUM_ROWS = 6;
    private static final int NUM_COLS = 15;

    public MainTvFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        prepareBackgroundManager();
        setupUIElements();
        loadRows();

        setOnSearchClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Implement your own in-app search", Toast.LENGTH_LONG).show();
            }
        });
    }



    private void prepareBackgroundManager() {
        BackgroundManager mBackgroundManager = BackgroundManager.getInstance(getActivity());
        mBackgroundManager.attach(getActivity().getWindow());
        Drawable mDefaultBackground = getResources().getDrawable(R.drawable.background);
        DisplayMetrics mMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
        //mBackgroundManager.setDrawable(mDefaultBackground);
    }

    private void setupUIElements() {
        // setBadgeDrawable(getActivity().getResources().getDrawable(
        // R.drawable.videos_by_google_banner));
        setTitle(getString(R.string.title)); // Badge, when set, takes precedent
        // over title
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        // set fastLane (or headers) background color
        setBrandColor(getResources().getColor(R.color.background_color));
        // set search icon color
        setSearchAffordanceColor(getResources().getColor(android.R.color.white));
    }

    private void loadRows() {
        List<MovieAdapter> list = MovieList.setupMovies();

        ArrayObjectAdapter mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        MovieCardPresenter cardPresenter = new MovieCardPresenter();

        int i;
        for (i = 0; i < NUM_ROWS; i++) {
            if (i != 0) {
                Collections.shuffle(list);
            }
            ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(cardPresenter);

            for (int j = 0; j < NUM_COLS; j++) {
                listRowAdapter.add(list.get(j % 5));
            }
            HeaderItem header = new HeaderItem(i, MovieList.MOVIE_CATEGORY[i]);
            mRowsAdapter.add(new ListRow(header, listRowAdapter));
        }

        setHeaderPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object item) {
                return new IconHeaderItemPresenter();
            }
        });

        HeaderItem gridHeader = new HeaderItem(i, "PREFERENCES");

        GridItemPresenter mGridPresenter = new GridItemPresenter(getActivity());
        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(mGridPresenter);
        gridRowAdapter.add(getResources().getString(R.string.grid_view));
        gridRowAdapter.add(getString(R.string.error_fragment));
        gridRowAdapter.add(getResources().getString(R.string.personal_settings));
        //mRowsAdapter.add(new ListRow(gridHeader, gridRowAdapter));

        setAdapter(mRowsAdapter);
    }

}
