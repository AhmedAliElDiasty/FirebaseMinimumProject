package com.example.ahmedel_diasty.firebasetest.recyclePackage;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.ahmedel_diasty.firebasetest.R;
import com.example.ahmedel_diasty.firebasetest.module.Module;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RecyclerClass extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    ArrayList<Module> arrayStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_class);
        recyclerView = findViewById(R.id.RecyclerView);




        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Personal Data");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayStudents = new ArrayList<>();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Module module = snapshot.getValue(Module.class);
                    arrayStudents.add(module);

                }

                adapter = new RecyclerAdapter(getApplicationContext(),arrayStudents);
                Toast.makeText(RecyclerClass.this,""+arrayStudents.get(0).getName(),Toast.LENGTH_LONG).show();
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(RecyclerClass.this);
                recyclerView.setLayoutManager(layoutmanager);
                recyclerView.setItemAnimator( new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("+++++++++++++++++","Cancelled");
            }
        });
    }
}
