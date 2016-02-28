package com.servicesample.androidtvsample.Fragment.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;
import com.servicesample.androidtvsample.R;
import com.servicesample.androidtvsample.Widgets.LoopingSurfaceView;

/**
 * Created by cflor on 28.02.2016.
 */
public class VineViewHolder extends RecyclerView.ViewHolder {

    public LoopingSurfaceView loopingSurfaceView;
    public CircularImageView vineUserImageView;
    public TextView vineDescriptionTextView;
    public TextView vineUserName;

    public VineViewHolder(View itemView) {
        super(itemView);

        loopingSurfaceView = (LoopingSurfaceView) itemView.findViewById(R.id.looping_surface_view);
        vineUserImageView = (CircularImageView) itemView.findViewById(R.id.user_profile_picture);
        vineUserName = (TextView) itemView.findViewById(R.id.vine_user_name);
        vineDescriptionTextView = (TextView) itemView.findViewById(R.id.vines_description);
    }
}
