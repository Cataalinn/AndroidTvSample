package com.servicesample.androidtvsample.Manager.ImageUtils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.app.BackgroundManager;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Smart Mirror project
 */
public class BackgroundManagerTarget implements Target {

    private BackgroundManager mBackgroundManager;

    public BackgroundManagerTarget(BackgroundManager backgroundManager) {
        this.mBackgroundManager = backgroundManager;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        this.mBackgroundManager.setBitmap(bitmap);
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {
        this.mBackgroundManager.setDrawable(errorDrawable);
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
}
