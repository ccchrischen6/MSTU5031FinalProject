package com.example.mstu5031finalproject.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.activity.MainActivity;
import com.example.mstu5031finalproject.entity.User;

public class RegCourseViewHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    public TextView courseNumber;
    public TextView courseName;
    public TextView instructor;
    public TextView credit;
    public TextView room;
    public TextView time;

    public Button dropCourse;
    private User user;

    public RegCourseViewHolder(@NonNull View itemView, final Context context) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_view_reg_course);
        courseNumber = itemView.findViewById(R.id.reg_course_number);
        courseName = itemView.findViewById(R.id.reg_course_name);
        instructor = itemView.findViewById(R.id.reg_instructor);
        credit = itemView.findViewById(R.id.reg_course_credit);
        room = itemView.findViewById(R.id.reg_course_room);
        time = itemView.findViewById(R.id.reg_course_time);
        dropCourse = itemView.findViewById(R.id.reg_drop_course);
        dropCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
