package com.android.isp_application;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Set up the bottom navigation bar
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Set the default fragment (first time opening the app)
        if (savedInstanceState == null) {
            // Set ProgramsFragment as the default
            navView.setSelectedItemId(R.id.navigation_programs);
        }

        // Set listener for navigation item selection
        navView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            // Determine which fragment to display based on the selected item
            switch (item.getItemId()) {
                case R.id.navigation_programs:
                    selectedFragment = new ProgramsFragment();
                    break;
                case R.id.navigation_schedule:
                    selectedFragment = new ScheduleFragment();
                    break;
                case R.id.navigation_calendar:
                    selectedFragment = new CalendarFragment();
                    break;
                case R.id.navigation_info:
                    selectedFragment = new InfoFragment(); // Replace with your Info Fragment
                    break;
                case R.id.navigation_transit:
                    selectedFragment = new fragment_transitinfo();
                    break;

            }

            // Replace the current fragment with the selected one
            if (selectedFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, selectedFragment);
                transaction.addToBackStack(null); // Optional: allows back navigation
                transaction.commit();
            }

            return true;
        });
    }
}
