package com.servicesample.androidtvsample.Manager.ImageUtils;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.servicesample.androidtvsample.Manager.ImageUtils
 */

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.ImageCardView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Picasso Target implementation used to load images using Picasso into ImageCard views.
 */
public class PicassoImageCardViewTarget implements Target {

    private ImageCardView mImageCardView;

    public PicassoImageCardViewTarget(ImageCardView mImageCardView) {
        this.mImageCardView = mImageCardView;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        Drawable bitmapDrawable = new BitmapDrawable(mImageCardView.getContext().getResources(), bitmap);
        mImageCardView.setMainImage(bitmapDrawable);
    }

    @Override
    public void onBitmapFailed(Drawable drawable) {
        mImageCardView.setMainImage(drawable);
    }

    @Override
    public void onPrepareLoad(Drawable drawable) {

    }
}