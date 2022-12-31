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
import com.example.drdypuser.ui.about.CourseModel;

import java.util.List;


public class VissionAdapter extends PagerAdapter {
    private Context context;
    private List<VissionModel> list;

    public VissionAdapter(Context context, List<VissionModel> list) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.vission_item_layout,container,false);

        ImageView vIcon;
        TextView vTitle, vDesc;

        vIcon = view.findViewById(R.id.v_icon);
        vTitle = view.findViewById(R.id.v_title);
        vDesc = view.findViewById(R.id.v_desc);

        vIcon.setImageResource(list.get(position).getImg());

        vTitle.setText(list.get(position).getTitle());

        vDesc.setText(list.get(position).getDescription());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
