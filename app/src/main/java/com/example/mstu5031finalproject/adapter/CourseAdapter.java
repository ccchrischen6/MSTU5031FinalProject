package com.example.mstu5031finalproject.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstu5031finalproject.constant.Constant;
import com.example.mstu5031finalproject.fragment.CourseInfoFragment;
import com.example.mstu5031finalproject.viewHolder.CourseViewHolder;
import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.entity.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {
    private List<Course> courses;
    private Context context;

    public CourseAdapter(List<Course> courses, Context context) {
        this.courses = courses;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_course, parent, false);
        return new CourseViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull final CourseViewHolder holder, final int position) {
        final Course course = courses.get(position);
        holder.courseNumber.setText(course.courseNumber);
        holder.courseName.setText(course.courseName);
        holder.courseIntro.setText(course.courseIntro);
        holder.selectCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //transfer the selected course to courseInfoFragment
                CourseInfoFragment cif = new CourseInfoFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Constant.SELECTED_COURSE, holder.courseNumber.getText().toString());
                cif.setArguments(bundle);

                //start courseInfoFragment
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cif).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
