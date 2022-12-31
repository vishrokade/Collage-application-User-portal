package com.example.drdypuser.Ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.drdypuser.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ebookActivity extends AppCompatActivity {

    private RecyclerView ebookRecycler;
    private DatabaseReference reference,dbRef;
    private List<EbookData> list;
    private EbookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ebooks");

        ebookRecycler= findViewById(R.id.ebookRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("Pdf");
        
        getData();


    }

    private void getData() {

        reference = reference.child("pdf");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list = new ArrayList<>();

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    EbookData data = dataSnapshot.getValue(EbookData.class);
                    list.add(data);
                }
                adapter = new EbookAdapter(ebookActivity.this,list);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(ebookActivity.this));
                ebookRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(ebookActivity.this,error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}