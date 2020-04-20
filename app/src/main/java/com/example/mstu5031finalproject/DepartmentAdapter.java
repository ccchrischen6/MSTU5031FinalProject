package com.example.mstu5031finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentViewHolder> {

    private List<Department> departments;
    private Context context;

    public DepartmentAdapter(List<Department> departments, Context context) {
        this.departments = departments;
        this.context = context;
    }

    @NonNull
    @Override
    public DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_department, parent, false);
        return new DepartmentViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewHolder holder, final int position) {
        final Department department = departments.get(position);
        holder.departmentPhoto.setImageResource(department.departmentPhoto);
        holder.departmentName.setText(department.departmentName);
        holder.departmentAbb.setText(department.departmentAbb);
        holder.selectDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(department.departmentAbb.equals("MSTU")){
                    Intent intent = new Intent(context,CourseActivity.class);
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, departments.get(position).departmentAbb + " Is Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return departments.size();
    }
}
