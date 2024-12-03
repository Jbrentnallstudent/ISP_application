package com.android.isp_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.List;

public class Calendar extends Fragment{
    @Entity
    public static class Event {
        @PrimaryKey(autoGenerate = true)
        public int id;

        public String title;
        public String description;
        public String date;
        public String time;
    }

    @Database(entities = {Event.class}, version = 1)
    public abstract static class AppDatabase extends RoomDatabase {
        public abstract EventDao eventDao();
    }

    @Dao
    public interface EventDao {
        @Insert
        void insert(Event event);

        @Query("SELECT * FROM Event WHERE date = :date")
        List<Event> getEventsByDate(String date);
    }

    private AppDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calendar, container, false);

        db = Room.databaseBuilder(getContext(), AppDatabase.class, "events.db")
                .allowMainThreadQueries() // Avoid on the main thread in production code
                .build();

        MaterialCalendarView calendarView = root.findViewById(R.id.material_calendar_view);
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(MaterialCalendarView widget, CalendarDay date, boolean selected) {
                String selectedDate = date.getYear() + "-" + (date.getMonth() + 1) + "-" + date.getDay();
                fetchEvents(selectedDate);
            }
        });

        return root;
    }

    private void fetchEvents(String date) {
        List<Event> events = db.eventDao().getEventsByDate(date);

        if (events.isEmpty()) {
            Toast.makeText(getContext(), "No events for " + date, Toast.LENGTH_SHORT).show();
        } else {
            StringBuilder eventDetails = new StringBuilder("Events for " + date + ":\n");
            for (Event event : events) {
                eventDetails.append(event.title).append("\n");
            }
            Toast.makeText(getContext(), eventDetails.toString(), Toast.LENGTH_LONG).show();
        }
    }
}




