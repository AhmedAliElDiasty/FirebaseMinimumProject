package com.example.ahmedel_diasty.firebasetest.recyclePackage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmedel_diasty.firebasetest.R;
import com.example.ahmedel_diasty.firebasetest.module.Module;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RowViewHolder> {
    private Context context;
    ArrayList<Module> arrayStudents;


    public RecyclerAdapter(Context context, ArrayList<Module> arrayStudents) {
        this.context = context;
        this.arrayStudents = arrayStudents;

    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        RowViewHolder viewHolder = new RowViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        String name = arrayStudents.get(position).getName();
        holder.name.setText(name);

        String age = arrayStudents.get(position).getAge();
        holder.age.setText(age);

        String phone = arrayStudents.get(position).getPhone();
        holder.phone.setText(phone);


    }

    @Override
    public int getItemCount() {
        return arrayStudents.size();
    }


    class RowViewHolder extends RecyclerView.ViewHolder{
        TextView name, age, phone;

        public RowViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            phone = itemView.findViewById(R.id.phone);
        }
    }
}
