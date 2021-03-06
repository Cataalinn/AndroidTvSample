package com.servicesample.androidtvsample.Manager.ImageUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import com.squareup.picasso.Transformation;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Smart Mirror project
 */
public class BlurTransformation implements Transformation {

    private final Context mContext;
    private static final int RADIUS = 20;

    public BlurTransformation(Context context) {
        this.mContext = context;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        Bitmap original = source;
        Bitmap blurred;
        blurred = Bitmap.createBitmap(original);

        RenderScript rs = RenderScript.create(mContext);

        Allocation input = Allocation.createFromBitmap(rs, original, Allocation.MipmapControl.MIPMAP_FULL, Allocation.USAGE_SCRIPT);
        Allocation output = Allocation.createTyped(rs, input.getType());

        ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        script.setInput(input);
        script.setRadius(RADIUS);
        script.forEach(output);

        output.copyTo(blurred);
        source.recycle();
        return blurred;
    }

    @Override
    public String key() {
        return "BlurTransformation";
    }
}