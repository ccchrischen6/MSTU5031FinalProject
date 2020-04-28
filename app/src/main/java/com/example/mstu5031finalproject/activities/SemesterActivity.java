package com.example.mstu5031finalproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.SemesterAdapter;
import com.example.mstu5031finalproject.entity.Semester;

import java.util.ArrayList;
import java.util.List;

public class SemesterActivity extends AppCompatActivity {

    private List<Semester> semesters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);
        setTitle(getString(R.string.select_a_semester));

        initialData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SemesterAdapter(semesters,this));
    }

    private void initialData() {
        semesters = new ArrayList<>();
        semesters.add(new Semester(getString(R.string.summer_2020_term), getString(R.string.summer_2020_term_time), R.drawable.summer2020));
        semesters.add(new Semester(getString(R.string.fall_2020_term), getString(R.string.fall_2020_term_time), R.drawable.fall2020));
    }
}

