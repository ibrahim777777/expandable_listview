package com.example.expandable_listview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class myadapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<String> titles;
    private HashMap<String,ArrayList<items>> dd;

    public myadapter(Context context, ArrayList<String> titles, HashMap<String, ArrayList<items>> dd) {
        this.context = context;
        this.titles = titles;
        this.dd = dd;
    }

    @Override
    public int getGroupCount() {
        return this.titles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.dd.get(this.titles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.titles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.dd.get(this.titles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        String ss= (String) getGroup(groupPosition);
        convertView=inflater.inflate(R.layout.head,null);
        TextView tt=convertView.findViewById(R.id.textView);
        tt.setText(ss);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        items it = (items) getChild(groupPosition,childPosition);

        convertView=inflater.inflate(R.layout.content,null);
        TextView text=convertView.findViewById(R.id.textView3);
        ImageView image=convertView.findViewById(R.id.imageView2);
        text.setText(it.namee);
        image.setImageResource(it.imagee);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
