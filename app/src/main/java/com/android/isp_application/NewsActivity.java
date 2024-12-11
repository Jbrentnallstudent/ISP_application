package com.android.isp_application;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import java.util.List;

public class NewsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DaoDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        db = Room.databaseBuilder(getApplicationContext(),
                        DaoDatabase.class, "school_database")
                .allowMainThreadQueries() // Only for testing
                .build();

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch data and bind adapter
        setupRecyclerView();


    }

    private void setupRecyclerView() {
        List<NewsEntity> newsList = db.newsDao().getAllNews();
        NewsAdapter adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);
    }
}