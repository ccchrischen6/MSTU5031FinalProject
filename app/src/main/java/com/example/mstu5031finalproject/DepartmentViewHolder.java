package com.example.mstu5031finalproject;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DepartmentViewHolder extends RecyclerView.ViewHolder {
    public CardView cardView;
    public ImageView departmentPhoto;
    public TextView departmentName;
    public TextView departmentAbb;
    public Button selectDepartment;

    public DepartmentViewHolder(@NonNull View itemView, final Context context) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_view_department);
        departmentPhoto = itemView.findViewById(R.id.department_photo);
        departmentName = itemView.findViewById(R.id.department_name);
        departmentAbb = itemView.findViewById(R.id.department_abb);
        selectDepartment = itemView.findViewById(R.id.select_department);

    }
}
