package com.android.isp_application;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgramsActivity extends AppCompatActivity {
    HashMap<String, List<String>> myHeader;
    List<String> myChild;
    ExpandableListView expandableListView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);
        expandableListView = (ExpandableListView) findViewById(R.id.lvProgram);
        myHeader = DataProvider.getInfo();
        myChild = new ArrayList<>(myHeader.keySet());
        adapter = new MyAdapter(this, myHeader,myChild);
        expandableListView.setAdapter(adapter);
    }
}

class MyAdapter extends BaseExpandableListAdapter {
    private Context ctx;
    private HashMap<String, List<String>> ChildTitles;
    private List<String> HeaderTitles;

    MyAdapter(Context ctx, HashMap<String, List<String>> ChildTitles, List<String> HeaderTitles) {
        this.ctx = ctx;
        this.ChildTitles = ChildTitles;
        this.HeaderTitles = HeaderTitles;
    }

    @Override
    public int getGroupCount() {
        return HeaderTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ChildTitles.get(HeaderTitles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return HeaderTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return ChildTitles.get(HeaderTitles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String) this.getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cell_program,null);
        }
        TextView txt = (TextView) convertView.findViewById(R.id.idTitle);
        txt.setTypeface(null, Typeface.BOLD);
        txt.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title = (String) this.getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_program, null);
        }

        TextView txt = (TextView) convertView.findViewById(R.id.idChild);
        txt.setText(title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

