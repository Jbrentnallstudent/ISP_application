package com.android.isp_application;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ScheduleEntity.class, NewsEntity.class}, version = 1)
public abstract class DaoDatabase extends RoomDatabase{
    public abstract ScheduleDao scheduleDao();
    public abstract NewsDao newsDao();
}
