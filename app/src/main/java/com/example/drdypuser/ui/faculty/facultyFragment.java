package com.example.drdypuser.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.drdypuser.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class facultyFragment extends Fragment {
    private RecyclerView csDepartment,aidsDepartment,otherDepartment;
    private LinearLayout csNoData, aidsNoData,otherNoData;
    private teacherAdapter adapter;

    private List<TeacherData> list1,list2,list3;

    private DatabaseReference reference,dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_faculty, container, false);


        csNoData = view.findViewById(R.id.csNoData);
        aidsNoData = view.findViewById(R.id.aidsNoData);
        csDepartment = view.findViewById(R.id.csDepartment);
        aidsDepartment = view.findViewById(R.id.aidsDepartment);
        otherNoData = view.findViewById(R.id.otherNoData);
        otherDepartment = view.findViewById(R.id.otherDepartment);

        reference = FirebaseDatabase.getInstance().getReference().child("Faculty");

        csDepartment();
        aidsDepartment();
        otherDepartment();

        return view;
    }

    private void csDepartment() {
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot DataSnapshot: dataSnapshot.getChildren()){
                        TeacherData data = DataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new teacherAdapter(list1,getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void aidsDepartment() {
        dbRef = reference.child("AIDS");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    aidsNoData.setVisibility(View.VISIBLE);
                    aidsDepartment.setVisibility(View.GONE);
                }else{
                    aidsNoData.setVisibility(View.GONE);
                    aidsDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot DataSnapshot:dataSnapshot.getChildren()){
                        TeacherData data =DataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    aidsDepartment.setHasFixedSize(true);
                    aidsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new teacherAdapter(list2,getContext());
                    aidsDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void otherDepartment() {
        dbRef = reference.child("Other");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    otherNoData.setVisibility(View.VISIBLE);
                    otherDepartment.setVisibility(View.GONE);
                }else{
                    otherNoData.setVisibility(View.GONE);
                    otherDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot DataSnapshot:dataSnapshot.getChildren()){
                        TeacherData data =DataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    otherDepartment.setHasFixedSize(true);
                    otherDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new teacherAdapter(list3,getContext());
                    otherDepartment.setAdapter(adapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}