package com.servicesample.androidtvsample.Widget;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.servicesample.androidtvsample.Widget
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.servicesample.androidtvsample.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PreviewCardView extends FrameLayout {

    @Bind(R.id.main_container)
    FrameLayout mMainContainer;

    @Bind(R.id.main_video)
    LoopingVideoView mVideoView;

    @Bind(R.id.main_image)
    ImageView mImageView;

    @Bind(R.id.view_overlay)
    View mOverlayView;

    @Bind(R.id.progress_card)
    ProgressBar mProgressCard;

    private String mVideoUrl;

    public PreviewCardView(Context context) {
        super(context);
        init();
    }

    public PreviewCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PreviewCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PreviewCardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        View view = inflate(getContext(), R.layout.widget_preview_card, this);
        ButterKnife.bind(view);
    }

    public void setVideoUrl(String videoUrl) {
        mVideoUrl = videoUrl;
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public void setLoading() {
        mOverlayView.setVisibility(View.VISIBLE);
        mProgressCard.setVisibility(View.VISIBLE);
        mVideoView.setVisibility(View.VISIBLE);
        mVideoView.setupMediaPlayer(mVideoUrl, new LoopingVideoView.OnVideoReadyListener() {
            @Override
            public void onVideoReady() {
                mOverlayView.setVisibility(View.INVISIBLE);
                mProgressCard.setVisibility(View.INVISIBLE);
                mImageView.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void setFinished() {
        mVideoView.setVisibility(View.INVISIBLE);
        mVideoView.stopMediaPlayer();
        mImageView.setVisibility(View.VISIBLE);
        mOverlayView.setVisibility(View.INVISIBLE);
        mProgressCard.setVisibility(View.INVISIBLE);
    }
}
