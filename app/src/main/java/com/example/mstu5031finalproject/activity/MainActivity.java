package com.example.mstu5031finalproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.constant.Constant;
import com.example.mstu5031finalproject.entity.User;
import com.example.mstu5031finalproject.fragment.AboutMeFragment;
import com.example.mstu5031finalproject.fragment.CalendarFragment;
import com.example.mstu5031finalproject.fragment.SemesterFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * this activity is the real main activity with navigation bar
 */
public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference userRef;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set the semester fragment as the home fragment
        SemesterFragment sf = new SemesterFragment();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.fragment_container, sf).commit();

        //add navigation bar
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //get userName
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        user = new User(acct.getDisplayName(), null);

        //setup user from firebase
        database = FirebaseDatabase.getInstance();
        userRef = database.getReference(Constant.USER);
//        userRef.addValueEventListener(listenerHelper());


    }

    private ValueEventListener listenerHelper(){
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //create local user if no record on the database
                if (!dataSnapshot.hasChild(user.getUserName())){
                    // set up the key for current user
                    DatabaseReference keyRef = userRef.child(user.getUserName());
                    keyRef.setValue(user);
                }

                //sync data from database
                else {
                    user = dataSnapshot.child(user.getUserName()).getValue(User.class);
                    System.out.println(user.getProfileUrl());
                    Intent intent = new Intent(MainActivity.this, CourseInfoActivity.class);

                    //transfer the User object to MainActivity
//                    intent.putExtra(Constant.USER, user);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        return listener;
    }



    //setup navigation bar listener
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_register:
                            selectedFragment = new SemesterFragment();
                            break;
                        case R.id.nav_calendar:
                            selectedFragment = new CalendarFragment();
                            break;
                        case R.id.nav_about_me:
                            selectedFragment = new AboutMeFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}
