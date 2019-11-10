package com.example.tvtime2;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalAdapterImage extends RecyclerView.Adapter<HorizontalAdapterImage.HorizontalViewHolder>{

    int[] images;

    public HorizontalAdapterImage(int[] images) {
        this.images = images;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shows_profile_recyclerview, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position){
        holder.txt.setImageResource(images[position]);
    }

    @Override
    public int getItemCount(){
        return images.length;

    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{
        ImageView txt;

        public HorizontalViewHolder(View itemView){
            super(itemView);
            txt = (ImageView) itemView.findViewById(R.id.shows_image);

        }
    }
}
