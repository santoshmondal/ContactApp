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
public class SimulationRecylerViewWithFilterAdapter extends RecyclerView.Adapter<SimulationRecylerViewWithFilterAdapter.SimulationRecylerViewWithFilterAdapterHolder> implements Filterable{

    private List<SamplePojo> dataList;
    private List<SamplePojo> filterDataList;
    private SearchFilter1 searchFilter1 = new SearchFilter1(SimulationRecylerViewWithFilterAdapter.this);

    public SimulationRecylerViewWithFilterAdapter(List<SamplePojo> dataList){
        this.dataList = dataList;
        this.filterDataList = dataList;
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
        holder.firstName.setText(filterDataList.get(position).getFirstName());
        holder.lastName.setText(filterDataList.get(position).getLastName());
        holder.address.setText(filterDataList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return filterDataList.size();
    }

    @Override
    public Filter getFilter() {
        return searchFilter1;
    }


    /** View Holder Class **/
    public class SimulationRecylerViewWithFilterAdapterHolder extends RecyclerView.ViewHolder {
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


    /** Search Filter **/
    public  class SearchFilter1 extends Filter {
        private SimulationRecylerViewWithFilterAdapter srvfAdapter;

        public SearchFilter1(SimulationRecylerViewWithFilterAdapter srvfAdapter){
            this.srvfAdapter = srvfAdapter;
        }

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<SamplePojo> dataListFilter = new ArrayList<>();


            final FilterResults results = new FilterResults();
            if (charSequence.length() == 0) {
                dataListFilter.addAll(dataList);
            } else {
                final String filterPattern = charSequence.toString().toLowerCase().trim();
                for (final SamplePojo ref : dataList) {
                    if (ref.getFirstName().toLowerCase().contains(filterPattern)) {
                        dataListFilter.add(ref);
                    }
                }
            }

            results.values = dataListFilter;
            results.count = dataListFilter.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            filterDataList = (List<SamplePojo>) filterResults.values;
            notifyDataSetChanged();
        }
    }
}
