package com.affixus.base.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.affixus.base.R;
import com.affixus.base.modals.SamplePojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santosh on 12/9/16.
 */
public class SimulationHomeAdapter extends RecyclerView.Adapter<SimulationHomeAdapter.SimulationHomeAdapterHolder>{
    private static final String TAG = SimulationHomeAdapter.class.getSimpleName();

    private Context context;
    private List<SamplePojo> dataList;

    public SimulationHomeAdapter(Context context, List<SamplePojo> dataList){
        this.context = context;
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
    public void onBindViewHolder(final SimulationHomeAdapterHolder holder, final int position) {
        holder.title.setText(dataList.get(position).getTitle());


        /** implement click **/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SamplePojo dataRef = dataList.get(position);
                Toast.makeText(view.getContext(), dataRef.getDescr() + " description!!", Toast.LENGTH_SHORT).show();

                Intent newIntent = new Intent(view.getContext(), dataRef.getActivityClass());
                context.startActivity(newIntent);
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "IMAGE_VIEW_CLICK", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }




    /** View Holder Class **/
    public class SimulationHomeAdapterHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;


        public SimulationHomeAdapterHolder(final View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);


            /** implement click **/
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Toast.makeText(itemView.getContext(), dataList.get(position).getDescr(), Toast.LENGTH_SHORT).show();
                }
            });

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Toast.makeText(itemView.getContext(), "Image View", Toast.LENGTH_SHORT).show();
                }
            });*/
        }
    }

}
