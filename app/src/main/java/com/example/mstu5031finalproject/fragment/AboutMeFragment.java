package com.example.mstu5031finalproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.activity.LoginActivity;
import com.example.mstu5031finalproject.adapter.CourseAdapter;
import com.example.mstu5031finalproject.adapter.RegCourseAdapter;
import com.example.mstu5031finalproject.entity.Course;
import com.example.mstu5031finalproject.entity.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AboutMeFragment extends Fragment {
    TextView name;
    GoogleSignInClient mGoogleSignInClient;
    private List<Course> courses = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_me, container, false);
        setHasOptionsMenu(true);
        setupGoogle(view);

        initialData();
        for (Course course : courses) {
            System.out.println(course.toString());
        }


        RecyclerView recyclerView = view.findViewById(R.id.reg_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RegCourseAdapter(courses, getContext()));

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sign_out) {
            mGoogleSignInClient.signOut();
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupGoogle(View view) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        name = view.findViewById(R.id.name);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getContext());
        if (acct != null) {
            String personName = acct.getDisplayName();
            //Uri personPhoto = acct.getPhotoUrl();
            name.setText(personName);
        }
    }

    private void initialData() {
        Map<String, Course> courseMap = ((User) this.getActivity().getApplication()).getRegCourses();
        for (Map.Entry<String, Course> entry : courseMap.entrySet()) {
            courses.add(entry.getValue());
        }
    }
}
