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
import com.example.mstu5031finalproject.activity.MainActivity;
import com.example.mstu5031finalproject.adapter.SemesterAdapter;
import com.example.mstu5031finalproject.entity.Semester;

import java.util.ArrayList;
import java.util.List;

public class SemesterFragment extends Fragment {
    private List<Semester> semesters;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_register, container, false);
        View view = inflater.inflate(R.layout.fragment_semester, container, false);


        initialData();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new SemesterAdapter(semesters,getContext()));



        return view;
    }

    private void initialData() {
        semesters = new ArrayList<>();
        semesters.add(new Semester(getString(R.string.summer_2020_term), getString(R.string.summer_2020_term_time), R.drawable.summer2020));
        semesters.add(new Semester(getString(R.string.fall_2020_term), getString(R.string.fall_2020_term_time), R.drawable.fall2020));
    }
}
