package com.android.isp_application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
    private List<NewsEntity> newsList;

    // Constructor
    public NewsAdapter(List<NewsEntity> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_cell, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsEntity news = newsList.get(position);
        holder.tvTitle.setText(news.getTitle());
        holder.tvTimestamp.setText(news.getTimestamp());
        holder.tvContent.setText(news.getContent());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    // ViewHolder class
    static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvTimestamp, tvContent;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvTimestamp = itemView.findViewById(R.id.tvTimestamp);
            tvContent = itemView.findViewById(R.id.tvContent);
        }
    }
}
