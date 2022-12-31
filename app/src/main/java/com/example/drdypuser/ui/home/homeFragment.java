package com.example.drdypuser.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.drdypuser.R;
import com.example.drdypuser.ui.about.CourseAdapter;
import com.example.drdypuser.ui.about.CourseModel;
import com.smarteist.autoimageslider.SliderView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;
import java.util.List;

public class homeFragment extends Fragment {


    private ViewPager people;
    private peopleAdopter adopterP;
    private List<peopleModel> listP;
    private ViewPager vision;
    private VissionAdapter adapterV;
    private List<VissionModel> listV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        listP = new ArrayList<>();
        listP.add(new peopleModel(R.drawable.image_1,"Founder"));
        listP.add(new peopleModel(R.drawable.image_2,"President"));
        listP.add(new peopleModel(R.drawable.image_3,"Secretory"));
        listP.add(new peopleModel(R.drawable.image_4,"Director"));
        listP.add(new peopleModel(R.drawable.image_5,"Principal"));

        adopterP = new peopleAdopter(getContext(),listP);
        people = view.findViewById(R.id.People);
        people.setAdapter(adopterP);

        listV = new ArrayList<>();
        listV.add(new VissionModel(R.drawable.ic_vision,"Vision","To achieve excellence in quality education through value based rapidly changing technologies and create technical human resource with proficiencies of accepting new challenges"));
        listV.add(new VissionModel(R.drawable.ic_mission,"Mission","Continuously strive to impart value-based education to elevate satisfaction level of all stakeholders. Take dedicated efforts to create competent professionals by effective teaching learning process with passion of lifelong learning attitude."));

        adapterV = new VissionAdapter(getContext(),listV);
        vision = view.findViewById(R.id.vission);
        vision.setAdapter(adapterV);

        return view;
    }

}
