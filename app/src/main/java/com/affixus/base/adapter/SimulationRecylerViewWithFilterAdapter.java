package com.affixus.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.affixus.base.R;
import com.affixus.base.modals.SamplePojo;

import java.util.List;

/**
 * Created by santosh on 12/9/16.
 */

public class SimulationRecylerViewWithFilterAdapter extends RecyclerView.Adapter<SimulationRecylerViewWithFilterAdapter.SimulationRecylerViewWithFilterAdapterHolder>{

    private List<SamplePojo> dataList;
    public SimulationRecylerViewWithFilterAdapter(List<SamplePojo> dataList){
        this.dataList = dataList;
    }


    @Override
    public SimulationRecylerViewWithFilterAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.simulation_layout, parent, false);

        SimulationRecylerViewWithFilterAdapterHolder holder = new SimulationRecylerViewWithFilterAdapterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SimulationRecylerViewWithFilterAdapterHolder holder, int position) {
        holder.firstName.setText(dataList.get(position).getFirstName());
        holder.lastName.setText(dataList.get(position).getLastName());
        holder.address.setText(dataList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    /** View Holder Class **/
    public static class SimulationRecylerViewWithFilterAdapterHolder extends RecyclerView.ViewHolder {
        TextView firstName;
        TextView lastName;
        TextView fullName;

        TextView mobile;
        TextView email;
        TextView address;


        public SimulationRecylerViewWithFilterAdapterHolder(View itemView) {
            super(itemView);

            firstName = (TextView) itemView.findViewById(R.id.tvFirstName);
            lastName  = (TextView) itemView.findViewById(R.id.tvLastName);
            address = (TextView) itemView.findViewById(R.id.tvAddress);
        }
    }
}
