package com.example.drdypuser.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.drdypuser.FullImageView;
import com.example.drdypuser.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.Galleryviewadapter> {

    private Context context;
    private List<String> images;

    public GalleryAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public Galleryviewadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.gallery_image,parent,false);

        return new Galleryviewadapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Galleryviewadapter holder, int position) {

        try {
            Glide.with(context).load(images.get(position)).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullImageView.class);
                intent.putExtra("image",images.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class Galleryviewadapter extends RecyclerView.ViewHolder {

        ImageView imageView;
        public Galleryviewadapter(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.galleryimage);
        }
    }
}
