package com.servicesample.androidtvsample.Fragment.Adapter;

import com.servicesample.androidtvsample.R;

/**
 * Created by Florescu George Cătălin on 17.02.2016.
 * Smart Mirror project
 */
public class MovieAdapter {
    private String title, description, category;

    public MovieAdapter() {
        title = "MovieAdapter Title";
        description = "MovieAdapter Description";
        category = "MovieAdapter Category";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getUrl() {
        return "https://www.hit2k.com/wp-content/uploads/2015/08/Chrooma-Live-Wallpaper-Hit2k.png";
    }

    public int getErrorCover() {
        return R.drawable.error;
    }

    public int getCover() {
        return R.drawable.cover;
    }
}
