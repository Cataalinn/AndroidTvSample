package com.servicesample.androidtvsample.Fragment.Adapter;

import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.view.ViewGroup;

import com.servicesample.androidtvsample.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Florescu George Cătălin on 17.02.2016.
 * Smart Mirror project
 */
public class MovieCardPresenter extends Presenter {

    private static final int CARD_WIDTH = 313;
    private static final int CARD_HEIGHT = 176;
    private static int selectedColor, unselectedColor;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        selectedColor = parent.getResources().getColor(R.color.selected_card);
        unselectedColor = parent.getResources().getColor(R.color.unselected_card);

        ImageCardView cardView = new ImageCardView(parent.getContext()) {
            @Override
            public void setSelected(boolean selected) {
                updateCardBackgroundColor(this, selected);
                super.setSelected(selected);
            }
        };

        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        updateCardBackgroundColor(cardView, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        MovieAdapter movieAdapter = (MovieAdapter) item;

        ImageCardView cardView = (ImageCardView) viewHolder.view;

        if (movieAdapter.getUrl() != null) {
            cardView.setTitleText(movieAdapter.getTitle());
            cardView.setContentText(movieAdapter.getDescription());
            cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
            Picasso.with(viewHolder.view.getContext()).load(movieAdapter.getCover()).error(movieAdapter.getErrorCover()).into(cardView.getMainImageView());
        }
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        cardView.setBadgeImage(null);
        cardView.setMainImage(null);
    }

    private static void updateCardBackgroundColor(ImageCardView view, boolean selected) {
        int color = selected ? selectedColor : unselectedColor;
        view.setBackgroundColor(color);
        view.findViewById(R.id.info_field).setBackgroundColor(color);
    }
}
