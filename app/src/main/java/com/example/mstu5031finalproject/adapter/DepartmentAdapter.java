package com.example.mstu5031finalproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstu5031finalproject.fragment.CourseFragment;
import com.example.mstu5031finalproject.viewHolder.DepartmentViewHolder;
import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.entity.Department;

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
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    CourseFragment cf = new CourseFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cf).addToBackStack(null).commit();
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
