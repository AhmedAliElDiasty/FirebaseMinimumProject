package com.example.ahmedel_diasty.firebasetest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmedel_diasty.firebasetest.module.Module;
import com.example.ahmedel_diasty.firebasetest.recyclePackage.RecyclerClass;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String TAG = "+++++++++++++++++++";
    Button addString;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        addString = findViewById(R.id.getData);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Personal Data");
        Module module = new Module("Mohamed","25","0415450540");
//        myRef.push().setValue(module);
//        myRef.setValue("Hello I'm Ahmed Eldiasty");
//        getDataFromSetter();



    }
    public void getDataFromSetter(){
        FirebaseDatabase.getInstance().getReference("Personal Data").child("students").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               textView.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void getDataFromPushing() {

    }
    public void getData(View view){
        Intent intent = new Intent(getApplicationContext(), RecyclerClass.class);
        startActivity(intent);

    }
}
