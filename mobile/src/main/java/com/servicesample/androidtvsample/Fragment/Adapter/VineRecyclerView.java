package com.servicesample.androidtvsample.Fragment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nodomain.vinedomain.Entity.Vine;
import com.servicesample.androidtvsample.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cflor on 28.02.2016.
 */
public class VineRecyclerView extends RecyclerView.Adapter<VineViewHolder> {

    private List<Vine> vines;
    private Context context;

    public VineRecyclerView(Context context, List<Vine> vines) {
        this.vines = vines;
        this.context = context;
    }

    @Override
    public VineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vine_view_holder, parent, false);
        return new VineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VineViewHolder holder, int position) {
        Vine vine = vines.get(position);
        holder.itemView.setTag(vine);
        // load vine thumbnail image and show progress bar
        holder.loopingSurfaceView.showPlaceHolders(vines.get(holder.getAdapterPosition()).vineThumbnailURL);
        // load video and start to play
        holder.loopingSurfaceView.loadAndPlay(vine.vineVideoURL);
        // load vine user image
        Picasso.with(context).load(vine.vineUserAvatarURL).placeholder(R.mipmap.vine_logo).into(holder.vineUserImageView);
        // load vine description
        holder.vineDescriptionTextView.setText(vine.vineDescription);
        // set number of likes
        holder.vineUserName.setText(vine.vineCreatorName);
    }


    @Override
    public void onViewDetachedFromWindow(VineViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.loopingSurfaceView.stopPlaying();
    }

    @Override
    public void onViewAttachedToWindow(VineViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public int getItemCount() {
        return vines.size();
    }
}
