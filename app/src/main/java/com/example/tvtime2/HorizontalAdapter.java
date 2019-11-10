package com.example.tvtime2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {

    ArrayList<ProfileInfo> items;

    public HorizontalAdapter(ArrayList<ProfileInfo> items){
        this.items=items;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_profile_layout_recycleview, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position){
        //holder.txt.setText(items[position]);
        holder.txt.setText(items.get(position).getText1());
        holder.txt2.setText(items.get(position).getText2());
        holder.txt3.setText(items.get(position).getText3());
    }

    @Override
    public int getItemCount(){
        return items.size();

    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{
        TextView txt;
        TextView txt2;
        TextView txt3;

        public HorizontalViewHolder(View itemView){
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.textView);
            txt2 = (TextView) itemView.findViewById(R.id.textView2);
            txt3 = (TextView) itemView.findViewById(R.id.textView3);

        }
    }
}
