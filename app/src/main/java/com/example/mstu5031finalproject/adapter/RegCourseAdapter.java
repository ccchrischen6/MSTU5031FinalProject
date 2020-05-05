package com.example.mstu5031finalproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.activity.CourseInfoActivity;
import com.example.mstu5031finalproject.activity.MainActivity;
import com.example.mstu5031finalproject.entity.Course;
import com.example.mstu5031finalproject.entity.User;
import com.example.mstu5031finalproject.viewHolder.CourseViewHolder;
import com.example.mstu5031finalproject.viewHolder.RegCourseViewHolder;

import java.util.List;

public class RegCourseAdapter extends RecyclerView.Adapter<RegCourseViewHolder> {
    private List<Course> regCourses;
    private Context context;
//    private MainActivity mainActivity;

    public RegCourseAdapter(List<Course> regCourses, Context context) {
        this.regCourses = regCourses;
        this.context = context;
//        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public RegCourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_reg_course, parent, false);
        return new RegCourseViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull final RegCourseViewHolder holder, final int position) {
        final Course course = regCourses.get(position);
        holder.courseNumber.setText(course.courseNumber);
        holder.courseName.setText(course.courseName);
        holder.instructor.setText(course.instructor);
        holder.credit.setText(course.credit);
        holder.room.setText(course.room);
        holder.time.setText(course.courseTime);
        holder.dropCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.courseName.getText() + "is dropped", Toast.LENGTH_LONG).show();
                regCourses.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, regCourses.size());
                holder.itemView.setVisibility(View.GONE);
            }
        });
    }




    @Override
    public int getItemCount() {
        return regCourses.size();
    }
}
