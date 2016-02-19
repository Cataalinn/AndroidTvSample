package com.nodomain.rottentomatoesapi.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
public class Movie {
    @SerializedName("title")
    public String movieTitle;

    @SerializedName("year")
    public String movieYear;

    @SerializedName("mpaa_rating")
    public String moviePEGIRating;

    @SerializedName("runtime")
    public String movieDuration;

    @SerializedName("ratings")
    public MovieRatings ratings;

    @SerializedName("synopsis")
    public String movieSynopsis;

    @SerializedName("posters")
    public MoviePosters moviePosters;

    @SerializedName("studio")
    public String movieStudio;

    @SerializedName("links")
    public MovieLinks movieLinks;
}
