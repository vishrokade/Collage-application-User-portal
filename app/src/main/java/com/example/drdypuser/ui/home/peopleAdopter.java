package com.example.drdypuser.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.drdypuser.R;

import java.util.List;

public class peopleAdopter extends PagerAdapter {
    private Context context;
    private List<peopleModel> list;

    public peopleAdopter(Context context, List<peopleModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.people_item_layout,container,false);

        ImageView peopleimage;
        TextView peopleTitle;

        peopleimage = view.findViewById(R.id.people_image);
        peopleTitle = view.findViewById(R.id.people_title);

        peopleimage.setImageResource(list.get(position).getImg());

        peopleTitle.setText(list.get(position).getTitle());



        container.addView(view,0);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}