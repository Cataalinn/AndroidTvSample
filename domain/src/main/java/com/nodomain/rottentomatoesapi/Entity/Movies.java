package com.nodomain.rottentomatoesapi.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Florescu George Cătălin on 18.02.2016.
 * Smart Mirror project
 */
public class Movies {
    @SerializedName("movies")
    public List<Movie> movies;
}
