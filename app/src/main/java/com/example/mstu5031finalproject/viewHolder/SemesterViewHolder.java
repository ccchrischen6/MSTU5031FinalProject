package com.example.mstu5031finalproject.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstu5031finalproject.R;

public class SemesterViewHolder extends RecyclerView.ViewHolder{
    public CardView cardView;
    public ImageView semesterPhoto;
    public TextView semesterName;
    public TextView semesterTime;
    public Button selectSemester;

    public SemesterViewHolder(@NonNull View itemView, final Context context) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_view_semester);
        semesterPhoto = itemView.findViewById(R.id.semester_photo);
        semesterName = itemView.findViewById(R.id.semester_name);
        semesterTime = itemView.findViewById(R.id.semester_time);
        selectSemester = itemView.findViewById(R.id.select_semester);
    }
}
