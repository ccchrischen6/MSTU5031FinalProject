package com.example.mstu5031finalproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mstu5031finalproject.DepartmentAdapter;
import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentActivity extends AppCompatActivity {

    private List<Department> departments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        setTitle(getString(R.string.select_a_department));

        initialData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DepartmentAdapter(departments,this));
    }

    private void initialData() {
        departments = new ArrayList<>();
        departments.add(new Department(getString(R.string.adult_learning_and_leadership), getString(R.string.orld), R.drawable.orld));
        departments.add(new Department(getString(R.string.human_cognition_and_learning), getString(R.string.hudk), R.drawable.hudk));
        departments.add(new Department(getString(R.string.com_computing_tech_in_edu), getString(R.string.mstu), R.drawable.mstu));
        departments.add(new Department(getString(R.string.measurement_and_evaluation), getString(R.string.hudm), R.drawable.hudm));
        departments.add(new Department(getString(R.string.clinical_psychology), getString(R.string.ccpx), R.drawable.ccpx));
    }
}
