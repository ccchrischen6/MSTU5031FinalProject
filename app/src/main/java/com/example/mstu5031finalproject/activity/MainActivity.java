package com.example.mstu5031finalproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mstu5031finalproject.R;
import com.example.mstu5031finalproject.fragment.AboutMeFragment;
import com.example.mstu5031finalproject.fragment.CalendarFragment;
import com.example.mstu5031finalproject.fragment.DepartmentFragment;
import com.example.mstu5031finalproject.fragment.SemesterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * this activity is the real main activity with navigation bar
 */
public class MainActivity extends AppCompatActivity {

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
    }

    //bind Fragment to navigation bar
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
