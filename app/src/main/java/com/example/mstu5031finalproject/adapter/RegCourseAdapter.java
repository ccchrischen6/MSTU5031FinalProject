package com.example.mstu5031finalproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.activity.CourseInfoActivity;
import com.example.mstu5031finalproject.entity.Course;
import com.example.mstu5031finalproject.entity.User;
import com.example.mstu5031finalproject.viewHolder.CourseViewHolder;
import com.example.mstu5031finalproject.viewHolder.RegCourseViewHolder;

import java.util.List;

public class RegCourseAdapter extends RecyclerView.Adapter<RegCourseViewHolder> {
    private List<Course> courses;
    private Context context;

    public RegCourseAdapter(List<Course> courses, Context context) {
        this.courses = courses;
        this.context = context;
    }

    @NonNull
    @Override
    public RegCourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_course, parent, false);
        return new RegCourseViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RegCourseViewHolder holder, final int position) {
        final Course course = courses.get(position);
        holder.courseNumber.setText(course.courseNumber);
        holder.courseName.setText(course.courseName);
        holder.instructor.setText(course.instructor);
        holder.credit.setText(course.credit);
        holder.room.setText(course.room);
        holder.time.setText(course.courseTime);
        holder.dropCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                drop();
            }
        });
    }

//    private void drop(){
//        ((User)
//    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
