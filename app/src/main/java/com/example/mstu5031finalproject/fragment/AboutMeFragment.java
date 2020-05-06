package com.example.mstu5031finalproject.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.activity.LoginActivity;
import com.example.mstu5031finalproject.adapter.CourseAdapter;
import com.example.mstu5031finalproject.adapter.RegCourseAdapter;
import com.example.mstu5031finalproject.constant.Constant;
import com.example.mstu5031finalproject.entity.Course;
import com.example.mstu5031finalproject.entity.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bumptech.glide.Glide;

import static android.app.Activity.RESULT_OK;

public class AboutMeFragment extends Fragment {
    TextView name;
    private ImageView profileImageView;
    private Uri profileUri;
    GoogleSignInClient mGoogleSignInClient;
    private List<Course> courses = new ArrayList<>();
    private static final int RC_PHOTO_PICKER = 2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_me, container, false);
        setHasOptionsMenu(true);
        setupGoogle(view);
        profileImageView = view.findViewById(R.id.image);
        handleProfileImage();
        handleDroppedCourse();
        initializeRecyclerView(view);

        return view;
    }

    //handle profile image if the image has been set
    private void handleProfileImage(){
        if(((User) getActivity().getApplication()).getProfileUrl() != null){
            try {
                profileUri = ((User) getActivity().getApplication()).getProfileUrl();
                Glide.with(profileImageView.getContext())
                        .load(profileUri)
                        .override(1280, 1280)
                        .centerCrop()
                        .crossFade()
                        .into(profileImageView);

                Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), profileUri);
                profileImageView.setImageBitmap(bitmapImage);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(intent, "Complete action using"), RC_PHOTO_PICKER);
            }
        });
    }

    private void initializeRecyclerView(View view){
        initialData();
        RecyclerView recyclerView = view.findViewById(R.id.reg_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RegCourseAdapter(courses, getContext()));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    //handle sign out function
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
            name.setText(personName);
        }
    }

    private void initialData() {
        Map<String, Course> courseMap = ((User) this.getActivity().getApplication()).getRegCourses();
        for (Map.Entry<String, Course> entry : courseMap.entrySet()) {
            courses.add(entry.getValue());
        }
    }

    //retrieve image from alubm
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super method removed
        if (resultCode == RESULT_OK) {
            try {
                Uri returnUri = data.getData();
                Glide.with(profileImageView.getContext())
                        .load(returnUri)
                        .override(1280, 1280)
                        .centerCrop()
                        .crossFade()
                        .into(profileImageView);


                Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), returnUri);
                profileImageView.setImageBitmap(bitmapImage);
                ((User) getActivity().getApplication()).setProfileUrl(returnUri);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }
    }


    //delete course from User's field regCourses if the course is dropped in RegCourseAdapter
    private void handleDroppedCourse(){
        Bundle bundle = this.getArguments();
        try {
            System.out.println("Dropping course");
            String droppedCourse = bundle.getString(Constant.DROPPED_COURSE);

            System.out.println(null == droppedCourse);
            if (droppedCourse != null && !droppedCourse.equals("")){
                ((User) getActivity().getApplication()).getRegCourses().remove(droppedCourse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
