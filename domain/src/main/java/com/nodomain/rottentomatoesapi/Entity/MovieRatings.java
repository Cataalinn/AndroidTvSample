package com.nodomain.rottentomatoesapi.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
public class MovieRatings {
    @SerializedName("critics_rating")
    public String criticsName;

    @SerializedName("critics_score")
    public int criticsScore;

    @SerializedName("audience_rating")
    public String audienceRating;

    @SerializedName("audience_score")
    public int audienceScore;
}
