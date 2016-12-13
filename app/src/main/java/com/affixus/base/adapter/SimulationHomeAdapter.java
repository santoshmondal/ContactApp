package com.affixus.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.affixus.base.R;
import com.affixus.base.modals.SamplePojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santosh on 12/9/16.
 */
public class SimulationHomeAdapter extends RecyclerView.Adapter<SimulationHomeAdapter.SimulationHomeAdapterHolder> {

    private List<SamplePojo> dataList;

    public SimulationHomeAdapter(List<SamplePojo> dataList){
        this.dataList = dataList;
    }


    @Override
    public SimulationHomeAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.simulation_layout_rv_home, parent, false);

        SimulationHomeAdapterHolder holder = new SimulationHomeAdapterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SimulationHomeAdapterHolder holder, int position) {
        holder.title.setText(dataList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    /** View Holder Class **/
    public class SimulationHomeAdapterHolder extends RecyclerView.ViewHolder {
        TextView title;


        public SimulationHomeAdapterHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }

}
