package com.example.mstu5031finalproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.adapter.CourseAdapter;
import com.example.mstu5031finalproject.adapter.DepartmentAdapter;
import com.example.mstu5031finalproject.entity.Course;
import com.example.mstu5031finalproject.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class CourseFragment extends Fragment {
    private List<Course> courses;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_register, container, false);
        View view = inflater.inflate(R.layout.fragment_department, container, false);

        initialData();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CourseAdapter(courses,getContext()));

        return view;
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
