package com.example.drdypuser.ui.faculty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drdypuser.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class teacherAdapter extends RecyclerView.Adapter<teacherAdapter.teacherViewAdopter> {

    private List<TeacherData> list;
    private Context context;

    public teacherAdapter(List<TeacherData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public teacherViewAdopter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);
        return new teacherViewAdopter(view);

    }

    @Override
    public void onBindViewHolder(@NonNull teacherViewAdopter holder, int position) {

        TeacherData item = list.get(position);
        try {
            Picasso.get().load(item.getImage()).placeholder(R.drawable.avatarprofile).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.post.setText(item.getPost());
        holder.subject.setText(item.getSubject());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class teacherViewAdopter extends RecyclerView.ViewHolder {
        private TextView name, email, post, subject;
        private ImageView imageView;

        public teacherViewAdopter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacherName);
            email = itemView.findViewById(R.id.teacherEmail);
            post = itemView.findViewById(R.id.teacherPost);
            subject = itemView.findViewById(R.id.teacherSub);
            imageView = itemView.findViewById(R.id.teacherImage);

        }
    }
}
