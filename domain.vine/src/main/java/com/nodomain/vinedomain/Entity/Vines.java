package com.nodomain.vinedomain.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain
 */
public class Vines {
    @SerializedName("success")
    public boolean isSuccess;

    @SerializedName("error")
    public String errorMessage;

    @SerializedName("data")
    public VinesData vinesData;
}
