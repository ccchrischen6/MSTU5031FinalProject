package com.example.mstu5031finalproject.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstu5031finalproject.R;

public class CourseViewHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    public TextView courseNumber;
    public TextView courseName;
    public TextView courseIntro;
    public Button selectCourse;

    public CourseViewHolder(@NonNull View itemView, final Context context) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_view_course);
        courseNumber = itemView.findViewById(R.id.course_number);
        courseName = itemView.findViewById(R.id.course_name);
        courseIntro = itemView.findViewById(R.id.course_intro);
        selectCourse = itemView.findViewById(R.id.select_course);
    }
}
