package com.affixus.base.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.affixus.base.R;
import com.affixus.base.adapter.SimulationRecylerViewWithFilterAdapter;
import com.affixus.base.modals.SamplePojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationRecylerViewWithFilter extends AppCompatActivity {
    private static final String TAG = SimulationRecylerViewWithFilter.class.toString();

    private RecyclerView rvSimulation1;
    private EditText etSearch;
    SimulationRecylerViewWithFilterAdapter srvfAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation_recyler_view_with_filter);

        initViewElements();
        initSearchFilter();


        List<SamplePojo> dataList = getDataList();
        srvfAdapter = new SimulationRecylerViewWithFilterAdapter(dataList);
        rvSimulation1.setAdapter(srvfAdapter);
        rvSimulation1.setLayoutManager(new LinearLayoutManager(this));
    }


    private void initViewElements(){
        rvSimulation1 = (RecyclerView) findViewById(R.id.rvSimulation1);
        etSearch = (EditText) findViewById(R.id.etSearch);
    }

    private void initSearchFilter() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // srvfAdapter.getFilter().filter(charSequence.toString());
                Log.i(TAG, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private List<SamplePojo> getDataList() {
        String[] nameArray = new String[]{"Affixus", "Dipak", "Hari", "Shashi", "Sunil", "Vipin"};

        List<SamplePojo> dataList = new ArrayList<>();
        Random r = new Random();
        int dataListCount = r.nextInt(10);

        for(int i=0; i<dataListCount; i++) {
            SamplePojo ref = new SamplePojo();

            int index = r.nextInt(5);
            ref.setFirstName(nameArray[index]);
            ref.setLastName("last name");
            ref.setAddress("address");

            dataList.add(ref);
        }

        return dataList;
    }
}
