package com.affixus.base.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.affixus.base.R;
import com.affixus.base.adapter.SimulationHomeAdapter;
import com.affixus.base.adapter.SimulationRecylerViewWithFilterAdapter;
import com.affixus.base.modals.SamplePojo;

import java.util.ArrayList;
import java.util.List;

public class SimulationHome extends AppCompatActivity {
    private static final String TAG = SimulationHome.class.toString();
    private RecyclerView rvHome;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simulation_home_activity);

        initViewElements();

        /** Adapter **/
        List<SamplePojo> dataList = getActivityList();
        SimulationHomeAdapter shAdapter = new SimulationHomeAdapter(dataList);
        rvHome.setAdapter(shAdapter);
        rvHome.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.simulation_menu_home, menu);
        return true;
    }


    private void initViewElements() {
        rvHome = (RecyclerView) findViewById(R.id.rvHome);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        // simulation_toolbar initialization
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private List<SamplePojo> getActivityList() {
        List<SamplePojo> list = new ArrayList<>();

        SamplePojo obj1 = new SamplePojo();
        obj1.setTitle("Search Filter");
        obj1.setDescr("Search Filter");
        obj1.setClassName(SimulationRecylerViewWithFilter.class.getName());

        SamplePojo obj2 = new SamplePojo();
        obj2.setTitle("Search Filter with Menu");
        obj2.setDescr("Search Filter with Menu");
        obj2.setClassName(SimulationRecylerViewWithFilter.class.getName());

        // Add all object into list
        list.add(obj1);
        list.add(obj2);


        // return list
        return list;
    }
}
