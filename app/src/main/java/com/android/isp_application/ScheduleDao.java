package com.android.isp_application;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ScheduleDao {
    @Insert
    void insertEvent(ScheduleEntity schedule);

    @Update
    void updateEvent(ScheduleEntity schedule);

    @Delete
    void deleteEvent(ScheduleEntity schedule);

    @Query("SELECT * FROM schedule WHERE date = :date")
    List<ScheduleEntity> getEventsByDate(String date);

    @Query("SELECT * FROM schedule")
    List<ScheduleEntity> getAllEvents();
}
