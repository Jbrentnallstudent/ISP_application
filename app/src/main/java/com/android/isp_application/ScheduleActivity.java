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
    }

    private void setupRecyclerView() {
        List<ScheduleEntity> scheduleList = db.scheduleDao().getAllEvents();
        ScheduleAdapter adapter = new ScheduleAdapter(scheduleList);
        recyclerView.setAdapter(adapter);
    }

}