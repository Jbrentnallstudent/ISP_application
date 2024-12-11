package com.android.isp_application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {
    private List<ScheduleEntity> scheduleList;

    // Constructor
    public ScheduleAdapter(List<ScheduleEntity> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_cell, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        ScheduleEntity schedule = scheduleList.get(position);
        holder.tvDate.setText(schedule.getDate());
        holder.tvEvent.setText(schedule.getEvent());
        holder.tvTime.setText(schedule.getTime());
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    // ViewHolder class
    static class ScheduleViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvEvent, tvTime;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvEvent = itemView.findViewById(R.id.tvEvent);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }
}
