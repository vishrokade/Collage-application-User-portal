package com.example.drdypuser.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.drdypuser.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class galleryFragment extends Fragment {

    RecyclerView functionRecycler,guestRecycler,visitRecycler,otherRecycler;
    GalleryAdapter adapter;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        functionRecycler = view.findViewById(R.id.functionRecycler);
        guestRecycler = view.findViewById(R.id.guestRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);
        visitRecycler = view.findViewById(R.id.visitRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");

        //functionRecycler.setSystemUiVisibility(view.getVisibility());
        getfunctionImage();
        getguestImage();
        getotherImage();
        getvisitImage();

        return view;
    }

    private void getfunctionImage() {
        reference.child("Function").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot DataSnapshot : snapshot.getChildren()){
                    String data = (String) DataSnapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                functionRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                functionRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getguestImage() {
        reference.child("Guest Lecture").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot DataSnapshot : snapshot.getChildren()){
                    String data = (String) DataSnapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                guestRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                guestRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getotherImage() {
        reference.child("Other").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot DataSnapshot : snapshot.getChildren()){
                    String data = (String) DataSnapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                otherRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getvisitImage() {
        reference.child("Visit").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot DataSnapshot : snapshot.getChildren()){
                    String data = (String) DataSnapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                visitRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                visitRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}