package com.nodomain.rottentomatoesapi.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
public class MovieLinks {
    @SerializedName("self")
    public String movieLinkSelfURL;

    @SerializedName("alternate")
    public String movieLinkAlternateURL;

    @SerializedName("cast")
    public String movieLinkCastURL;

    @SerializedName("clips")
    public String movieLinkClipsURL;

    @SerializedName("reviews")
    public String movieLinkReviewsURL;

    @SerializedName("similar")
    public String movieLinkSimilarURL;
}
