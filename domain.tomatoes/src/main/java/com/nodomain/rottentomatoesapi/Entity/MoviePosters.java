package com.nodomain.rottentomatoesapi.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
public class MoviePosters {
    @SerializedName("thumbnail")
    public String moviePosterThumbnailURL;

    @SerializedName("profile")
    public String moviePosterProfileURL;

    @SerializedName("detailed")
    public String moviePosterDetailURL;

    @SerializedName("original")
    public String moviePosterOriginalURL;
}
