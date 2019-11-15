package com.example.tvtime2;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NotificationInfoAdapter extends ArrayAdapter<NotificationInfo> {

    //variables
    private Context mContext;
    int mResource;

    public NotificationInfoAdapter(@NonNull Context context, int resource, @NonNull ArrayList<NotificationInfo> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    //Attaching to listView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int photo = getItem(position).getImage();
        String accomplishment = getItem(position).getAccomplishment();
        String day = getItem(position).getDay();

        LayoutInflater inflater = LayoutInflater.from(mContext);

        if(convertView == null){
            convertView = inflater.inflate(mResource, parent, false);
        }

        ImageView tvPhoto = convertView.findViewById(R.id.imageView);
        TextView tvAccomplishment = convertView.findViewById(R.id.textView2);
        TextView tvDay = convertView.findViewById(R.id.textView3);

        tvPhoto.setImageResource(photo);
        tvAccomplishment.setText(accomplishment);
        tvDay.setText(day);

        return convertView;

    }
}
