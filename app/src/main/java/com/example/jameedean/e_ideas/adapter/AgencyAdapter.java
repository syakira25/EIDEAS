package com.example.jameedean.e_ideas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jameedean.e_ideas.R;
import com.example.jameedean.e_ideas.model.AgencyModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by JameeDean on 12/11/2017.
 */

public class AgencyAdapter extends RecyclerView.Adapter<AgencyAdapter.AgencyViewHolder>  {

    private Context mContext;
    private ArrayList<AgencyModel> mData;

    private AgencyAdapter.OnItemClick mListener;

    public AgencyAdapter(Context context, AgencyAdapter.OnItemClick listener) {
        mContext = context;
        mData = new ArrayList<>();

        mListener = listener;
    }

    @Override
    public AgencyAdapter.AgencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_holder_agency, parent, false);
        return new AgencyAdapter.AgencyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AgencyAdapter.AgencyViewHolder holder, int position) {

        AgencyModel model = mData.get(position);

        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        // set description as log
        Picasso.with(mContext).load(model.getLogoUrl()).into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(AgencyModel model) {
        mData.add(model);

        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();

        notifyDataSetChanged();
    }

    public AgencyModel getItem(int position) {
        return mData.get(position);
    }

    public interface OnItemClick {
        void onClick(int pos);
    }

    class AgencyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView logo;
        private TextView name;
        private TextView email;

        AgencyViewHolder(View itemView) {
            super(itemView);

            logo = itemView.findViewById(R.id.iv_logo);
            name = itemView.findViewById(R.id.tv_name);
            email = itemView.findViewById(R.id.tv_email);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(getAdapterPosition());
        }
    }
}


