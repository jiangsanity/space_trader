package edu.gatech.cs2340.game.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.cs2340.game.R;
import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.views.SSItemFragment.OnListFragmentInteractionListener;

import java.util.List;

public class SSItemRecyclerViewAdapter extends RecyclerView.Adapter<SSItemRecyclerViewAdapter.ViewHolder> {

    private final List<SolarSystem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public SSItemRecyclerViewAdapter(List<SolarSystem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_ssitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.system = mValues.get(position);
        holder.nameView.setText(mValues.get(position).getName());
        holder.positionView.setText(mValues.get(position).getPos().toString());
        holder.resourcesView.setText(mValues.get(position).getResources().toString());
        holder.techLevelView.setText(mValues.get(position).getTechLevel().toString());

        holder.goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.system);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private SolarSystem system;
        private final Button goButton;

        private final TextView nameView;
        private final TextView positionView;
        private final TextView techLevelView;
        private final TextView resourcesView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nameView = (TextView) view.findViewById(R.id.ss_name);
            positionView = (TextView) view.findViewById(R.id.ss_position);
            techLevelView = (TextView) view.findViewById(R.id.ss_techlevel);
            resourcesView = (TextView) view.findViewById(R.id.ss_resources);
            goButton = (Button) view.findViewById(R.id.goButton);
        }
    }
}
