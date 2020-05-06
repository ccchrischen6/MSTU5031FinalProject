package com.example.mstu5031finalproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.constant.Constant;
import com.example.mstu5031finalproject.entity.Course;
import com.example.mstu5031finalproject.entity.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CourseInfoFragment extends Fragment {
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

    private User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_info, container, false);


        courseNumberTextView = view.findViewById(R.id.course_info_number);
        courseNameTextView = view.findViewById(R.id.course_name);
        instructorTextView = view.findViewById(R.id.instructor);
        creditTextView = view.findViewById(R.id.credit);
        remTextView = view.findViewById(R.id.rem);
        roomTextView = view.findViewById(R.id.room);
        timeTextView = view.findViewById(R.id.time);
        registerNow = view.findViewById(R.id.register_now_button);


        //receive courseNumber from courseFragment
        Bundle bundle = this.getArguments();
        courseNumber = bundle.getString(Constant.SELECTED_COURSE);
        courseNumberTextView.setText(courseNumber);

        user = (User) this.getActivity().getApplication();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference(Constant.MSTU).child(courseNumber);
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
                Course course = new Course(courseNumber, courseName, credit, room, time, instructor);
                ((User) getActivity().getApplication()).getRegCourses().put(courseName, course);


                CourseFragment cf = new CourseFragment();
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cf).addToBackStack(null).commit();
                Toast.makeText(getContext(), courseName + " is registered", Toast.LENGTH_LONG).show();


            }
        });


        return view;
    }
}
