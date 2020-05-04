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
import com.example.mstu5031finalproject.adapter.DepartmentAdapter;
import com.example.mstu5031finalproject.adapter.SemesterAdapter;
import com.example.mstu5031finalproject.entity.Department;
import com.example.mstu5031finalproject.entity.Semester;

import java.util.ArrayList;
import java.util.List;

public class DepartmentFragment extends Fragment {
    private List<Department> departments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_register, container, false);
        View view = inflater.inflate(R.layout.fragment_department, container, false);

        initialData();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new DepartmentAdapter(departments, getContext()));


        return view;
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
