package com.android.isp_application;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import java.util.List;
import androidx.core.view.WindowInsetsCompat;

public class ScheduleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DaoDatabase db;
    private ScheduleAdapter adapter;
    private List<ScheduleEntity> scheduleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        db = Room.databaseBuilder(getApplicationContext(),
                        DaoDatabase.class, "school_database")
                .allowMainThreadQueries() // Only for testing
                .build();

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewSchedule);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch data and bind adapter
        setupRecyclerView();
        // Populate the database with test data
        populateTestData();
        // Fetch and display schedule data
        fetchScheduleData();
    }

    private void setupRecyclerView() {
        List<ScheduleEntity> scheduleList = db.scheduleDao().getAllEvents();
        ScheduleAdapter adapter = new ScheduleAdapter(scheduleList);
        recyclerView.setAdapter(adapter);
    }

    private void populateTestData() {
        // Adding test schedule data
        ScheduleEntity schedule1 = new ScheduleEntity("2024-12-10", "Software Engineering Exam", "10:00 AM");
        ScheduleEntity schedule2 = new ScheduleEntity("2024-12-12", "Embedded Controller Presentation", "2:00 PM");
        ScheduleEntity schedule3 = new ScheduleEntity("2024-12-15", "Active Circuits Lecture", "9:00 AM");
        ScheduleEntity schedule4 = new ScheduleEntity("2024-12-20", "Project Submission Deadline", "11:59 PM");

        // Insert test schedule data into the database
        db.scheduleDao().insertEvent(schedule1);
        db.scheduleDao().insertEvent(schedule2);
        db.scheduleDao().insertEvent(schedule3);
        db.scheduleDao().insertEvent(schedule4);
    }

    private void fetchScheduleData() {
        // Fetch schedule data from the database
        scheduleList = db.scheduleDao().getAllEvents();

        // Initialize and set the adapter
        adapter = new ScheduleAdapter(scheduleList);
        recyclerView.setAdapter(adapter);
    }
}