package com.example.drdypuser.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.drdypuser.R;
import com.example.drdypuser.ui.home.peopleAdopter;
import com.example.drdypuser.ui.home.peopleModel;

import java.util.ArrayList;
import java.util.List;

public class aboutFragment extends Fragment {


    private ViewPager courses;
    private CourseAdapter adapter;
    private List<CourseModel> list;
    private ImageView map;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_computer,"Computer Science","Computer Engineering is the most flourishing discipline that cultivates at the crossroad of new trends in computer science. \n"));
        list.add(new CourseModel(R.drawable.ic_ai,"Artificial Intelligence","The Artificial Intelligence & Data Science is upcoming technology which are changing the world with very high pace.\n"));

        list.add(new CourseModel(R.drawable.ic_mecha,"Mechanical","The Department of Mechanical Engineering was established in year 2014. The Mechanical Engineering department offers four year Under Graduate Course..\n"));

        adapter = new CourseAdapter(getContext(),list);
        courses = view.findViewById(R.id.Courses);
        courses.setAdapter(adapter);

        map = view.findViewById(R.id.map1);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmap();
            }
        });
        return view;
    }

    private void openmap() {
        Uri uri = Uri.parse("geo:0, 0?q=Dr. D. Y. Patil College of Engineering and Innovation, SR. No. 27/A/1/2c, Near Eco City, Talegaon, Varale, Pune - 410507, Maharashtra, India");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}