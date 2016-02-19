package com.nodomain.vinedomain.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain.Entity
 */
public class VinesData {
    @SerializedName("count")
    public int vineCount;

    @SerializedName("records")
    public List<Vine> vineList;
}
