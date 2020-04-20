package com.example.mstu5031finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CourseInfoActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    private TextView courseNumberTextView;
    private TextView courseNameTextView;
    private TextView instructorTextView;
    private TextView creditTextView;
    private TextView remTextView;
    private TextView roomTextView;
    private TextView timeTextView;

    private Button registerNow;

    private String courseNumber;
    private String courseName;
    private String instructor;
    private String credit;
    private String rem;
    private String room;
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);

        setTitle("Course Information");
        courseNumberTextView = findViewById(R.id.course_info_number);
        courseNameTextView = findViewById(R.id.course_name);
        instructorTextView = findViewById(R.id.instructor);
        creditTextView = findViewById(R.id.credit);
        remTextView = findViewById(R.id.rem);
        roomTextView = findViewById(R.id.room);
        timeTextView = findViewById(R.id.time);
        registerNow = findViewById(R.id.register_now_button);

        Intent receiveIntent = getIntent();
        courseNumber = receiveIntent.getStringExtra("courseNumber");
        System.out.println(courseNumber);
        courseNumberTextView.setText(courseNumber);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("MSTU").child(courseNumber);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                courseName = dataSnapshot.child("courseName").getValue(String.class);
                courseNameTextView.setText(courseName);

                credit = dataSnapshot.child("credit").getValue().toString();
                creditTextView.setText(credit);

                rem = String.valueOf(dataSnapshot.child("rem").getValue(Long.class));
                remTextView.setText(rem);

                room = dataSnapshot.child("room").getValue(String.class);
                roomTextView.setText(room);

                time = dataSnapshot.child("time").getValue(String.class);
                timeTextView.setText(time);

                instructor = dataSnapshot.child("instructor").getValue(String.class);
                instructorTextView.setText(instructor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        registerNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseInfoActivity.this, AboutMeActivity.class);
                startActivity(intent);

            }
        });
    }


}



