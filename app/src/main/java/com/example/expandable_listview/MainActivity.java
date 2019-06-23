package com.example.expandable_listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    myadapter myadapter;
    ArrayList<String> titles;
    HashMap<String,ArrayList<items>> dd;

    ExpandableListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);
       titles=new ArrayList<String>();
       dd=new HashMap<String, ArrayList<items>>();
        titles.add("first");
        titles.add("second");
        ArrayList<items> firstt=new ArrayList<>();
        firstt.add(new items("this is first input",R.drawable.first));
        firstt.add(new items("this is second input",R.drawable.second));
        firstt.add(new items("this is third input",R.drawable.third));

        ArrayList<items> second=new ArrayList<>();
        second.add(new items("this is four input",R.drawable.four));
        second.add(new items("this is five input",R.drawable.five));
        second.add(new items("this is six input",R.drawable.sss));

        dd.put(titles.get(0),firstt);
        dd.put(titles.get(1),second);
        myadapter=new myadapter(this,titles,dd);
        list.setAdapter(myadapter);





    }
}
