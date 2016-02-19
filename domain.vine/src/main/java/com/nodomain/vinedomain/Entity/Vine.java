package com.nodomain.vinedomain.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Florescu George Cătălin on 19.02.2016.
 * Project name:  AndroidTvSample
 * Package name: com.nodomain.vinedomain.Entity
 */
public class Vine {
    @SerializedName("liked")
    public int vineLikesCount;

    @SerializedName("thumbnailUrl")
    public String vineThumbnailURL;

    @SerializedName("avatarUrl")
    public String vineUserAvatarURL;

    @SerializedName("videoLowURL")
    public String vineVideoLowResolutionURL;

    @SerializedName("username")
    public String vineCreatorName;

    @SerializedName("description")
    public String vineDescription;

    @SerializedName("videoUrl")
    public String vineVideoURL;

    @SerializedName("shareUrl")
    public String vineShareURL;
}
