package com.android.isp_application;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NewsDao {
    @Insert
    void insertNews(NewsEntity news);

    @Update
    void updateNews(NewsEntity news);

    @Delete
    void deleteNews(NewsEntity news);

    @Query("SELECT * FROM news ORDER BY timestamp DESC")
    List<NewsEntity> getAllNews();
}
