package com.servicesample.androidtvsample.Widgets;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.videocaching.CacheListener;
import com.example.videocaching.HttpProxyCacheServer;
import com.malmstein.fenster.view.FensterVideoView;
import com.servicesample.androidtvsample.R;
import com.servicesample.androidtvsample.VineApplication;
import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by cflor on 28.02.2016.
 */
public class LoopingSurfaceView extends RelativeLayout implements CacheListener {

    private Context context;

    @Bind(R.id.image_placeholder)
    ImageView placeHolder;

    @Bind(R.id.video_view)
    FensterVideoView videoView;

    @Bind(R.id.progressbar)
    ProgressBar progressBar;

    public LoopingSurfaceView(Context context) {
        super(context);
        init(context);
    }

    public LoopingSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoopingSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = inflate(getContext(), R.layout.looping_surface_view, this);

        ButterKnife.bind(view);
        this.context = context;
    }

    public void loadAndPlay(String videoUrl) {
        HttpProxyCacheServer proxy = VineApplication.getProxy(context);
        proxy.registerCacheListener(videoUrl, this);

        videoView.setVideo(proxy.getProxyUrl(videoUrl));
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // hide placeholder and release memory
                placeHolder.setVisibility(GONE);
                progressBar.setVisibility(GONE);
                placeHolder.setImageBitmap(null);

                // loop video and set volume to mute
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(0, 0);
            }
        });
    }

    public void stopPlaying() {
        videoView.stopPlayback();
    }

    @Override
    public void onCacheAvailable(File cacheFile, String url, int percentsAvailable) {

    }

    public void showPlaceHolders(String imageUrl) {
        placeHolder.setVisibility(VISIBLE);
        placeHolder.bringToFront();

        progressBar.setVisibility(VISIBLE);
        progressBar.bringToFront();

        Picasso.with(context).load(imageUrl).placeholder(R.mipmap.vine_logo).into(placeHolder);
    }
}
