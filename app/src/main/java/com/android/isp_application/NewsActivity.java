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
    private NewsAdapter adapter;
    private List<NewsEntity> newsList;

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

        // Populate the database with test data
        populateTestData();

        // Fetch and display news data
        fetchNewsData();
    }

    private void setupRecyclerView() {
        List<NewsEntity> newsList = db.newsDao().getAllNews();
        NewsAdapter adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);
    }

    private void populateTestData() {
        // Adding test news data
        NewsEntity news1 = new NewsEntity("New Semester Starts", "The new semester starts on January 15th, 2024.", "2024-12-01");
        NewsEntity news2 = new NewsEntity("Holiday Schedule", "Winter break runs from December 20th to January 5th, 2024.", "2024-11-30");
        NewsEntity news3 = new NewsEntity("Library Hours Update", "The library will be closed on December 25th for Christmas.", "2024-12-10");
        NewsEntity news4 = new NewsEntity("Final Exam Dates", "Final exams will begin on December 10th.", "2024-12-05");

        // Insert test news data into the database
        db.newsDao().insertNews(news1);
        db.newsDao().insertNews(news2);
        db.newsDao().insertNews(news3);
        db.newsDao().insertNews(news4);
    }

    private void fetchNewsData() {
        // Fetch news data from the database
        newsList = db.newsDao().getAllNews();

        // Initialize and set the adapter
        adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);
    }
}