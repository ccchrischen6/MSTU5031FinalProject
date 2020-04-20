package com.example.mstu5031finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private List<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        setTitle("Select Course");

        initialData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CourseAdapter(courses,this));
    }

    private void initialData(){
        courses = new ArrayList<>();
        courses.add(new Course(getString(R.string.mstu4001),getString(R.string.mstu4001_name),getString(R.string.mstu4001_intro)));
        courses.add(new Course(getString(R.string.mstu4023),getString(R.string.mstu4023_name),getString(R.string.mstu4023_intro)));
        courses.add(new Course(getString(R.string.mstu4031),getString(R.string.mstu4031_name),getString(R.string.mstu4031_intro)));
        courses.add(new Course(getString(R.string.mstu4040),getString(R.string.mstu4040_name),getString(R.string.mstu4040_intro)));
        courses.add(new Course(getString(R.string.mstu4083),getString(R.string.mstu4083_name),getString(R.string.mstu4083_intro)));
    }
}
