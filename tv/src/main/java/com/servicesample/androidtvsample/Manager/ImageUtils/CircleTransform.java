package com.servicesample.androidtvsample.Manager.ImageUtils;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.servicesample.androidtvsample.Manager.ImageUtils
 */

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.squareup.picasso.Transformation;

/**
 * Picasso Transformation created to apply a circular mask to the downloaded image.
 */
public class CircleTransform implements Transformation {

    private final int mSize;

    public CircleTransform(float size) {
        this.mSize = (int) size;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        Bitmap squaredBitmap = Bitmap.createScaledBitmap(source, mSize, mSize, false);
        if (squaredBitmap != source) {
            source.recycle();
        }
        Bitmap bitmap = Bitmap.createBitmap(mSize, mSize, source.getConfig());

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader =
                new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);

        float r = mSize / 2f;
        canvas.drawCircle(r, r, r, paint);

        squaredBitmap.recycle();
        return bitmap;
    }

    @Override
    public String key() {
        return "CircleTransformation";
    }
}