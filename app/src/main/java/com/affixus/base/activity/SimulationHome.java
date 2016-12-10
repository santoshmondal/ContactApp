package com.affixus.base.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.affixus.base.R;

public class SimulationHome extends AppCompatActivity {
    private static final String TAG = SimulationHome.class.toString();
    private RecyclerView rvHome;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simulation_home_activity);

        initViewElements();
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
}
