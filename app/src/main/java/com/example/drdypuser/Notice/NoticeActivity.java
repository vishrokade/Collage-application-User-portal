package com.example.drdypuser.Notice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.drdypuser.Ebook.EbookAdapter;
import com.example.drdypuser.Ebook.EbookData;
import com.example.drdypuser.Ebook.ebookActivity;
import com.example.drdypuser.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NoticeActivity extends AppCompatActivity {

    private RecyclerView noticeRecycler;
    private DatabaseReference reference,dbRef;
    private List<NoticePdfData> list;
    private noticePdfAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Notice Section");

        noticeRecycler= findViewById(R.id.noticeRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("NoticePdf");

        getData();


    }

    private void getData() {

        reference = reference.child("pdf");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list = new ArrayList<>();

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    NoticePdfData data = dataSnapshot.getValue(NoticePdfData.class);
                    list.add(data);
                }
                adapter = new noticePdfAdapter(NoticeActivity.this,list);
                noticeRecycler.setLayoutManager(new LinearLayoutManager(NoticeActivity.this));
                noticeRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(NoticeActivity.this,error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}