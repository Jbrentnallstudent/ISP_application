package com.android.isp_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Arrays;

// Custom classes
import com.android.isp_application.ProgramsAdapter;

public class Programs extends Fragment {
    private RecyclerView recyclerView;
    private ProgramsAdapter adapter;

    // Hardcoded list of courses
    private List<String> programs = Arrays.asList(
            "Architectural", "Civil", "Geomatics", "Computing Systems",
            "Electronics (Biomedical)", "Electronics (Instrumentation)",
            "Electrical (Power)", "Telecommunications", "Chemical Processing",
            "Industrial", "Mechanical", "Mechanical (Manufacturing)", "Petroleum"
    );

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_programs, container, false);

        recyclerView = root.findViewById(R.id.programs_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Use the hardcoded courses list
        adapter = new ProgramsAdapter(programs, program -> {
            // Here you can handle course selection if necessary
            // For example, you could display more details about the selected course
        });

        recyclerView.setAdapter(adapter);

        return root;
    }
}

public class ProgramsAdapter extends RecyclerView.Adapter<ProgramsAdapter.ProgramViewHolder> {
    private List<String> programs;
    private OnProgramClickListener listener;

    public ProgramsAdapter(List<String> programs, OnProgramClickListener listener) {
        this.programs = programs;
        this.listener = listener;
    }

    @Override
    public ProgramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_program, parent, false);
        return new ProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgramViewHolder holder, int position) {
        String program = programs.get(position);
        holder.programName.setText(program);
        holder.itemView.setOnClickListener(v -> listener.onProgramClick(program));
    }

    @Override
    public int getItemCount() {
        return programs.size();
    }

    public static class ProgramViewHolder extends RecyclerView.ViewHolder {
        TextView programName;

        public ProgramViewHolder(View itemView) {
            super(itemView);
            programName = itemView.findViewById(R.id.program_name);
        }
    }

    public interface OnProgramClickListener {
        void onProgramClick(String program);
    }
}
