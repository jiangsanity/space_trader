package edu.gatech.cs2340.game.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.cs2340.game.R;
import edu.gatech.cs2340.game.entity.GoodEntry;
import edu.gatech.cs2340.game.views.GoodEntryFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link GoodEntry} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class GoodEntryRecyclerViewAdapter extends RecyclerView.Adapter<GoodEntryRecyclerViewAdapter.ViewHolder> {

    private final List<GoodEntry> mValues;
    private final OnListFragmentInteractionListener mListener;

    public GoodEntryRecyclerViewAdapter(List<GoodEntry> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_goodentry, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final GoodEntry good = mValues.get(position);
        holder.nameView.setText(good.getItemName().substring(0, 1).toUpperCase() + good.getItemName().substring(1));
        holder.priceView.setText("Price: $" + good.getItemPrice());
        holder.shipInvView.setText("You: " + good.getShipInventory());
        holder.marketInvView.setText("Market: " + good.getMarketInventory());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction();
                }
            }
        });

        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                good.buyGood(1);
                updateUI(holder, good);
            }
        });

        holder.sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                good.sellGood(1);
                updateUI(holder, good);
            }
        });
    }

    private void updateUI(ViewHolder holder, GoodEntry good) {
        mListener.onListFragmentInteraction();
        holder.priceView.setText("Price: $" + good.getItemPrice());
        holder.shipInvView.setText("You: " + good.getShipInventory());
        holder.marketInvView.setText("Market: " + good.getMarketInventory());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;

        private final TextView nameView;
        private final TextView priceView;
        private final TextView shipInvView;
        private final TextView marketInvView;
        private final Button buyButton;
        private final Button sellButton;

        private ViewHolder(View view) {
            super(view);
            mView = view;
            nameView = view.findViewById(R.id.item_name);
            priceView = view.findViewById(R.id.item_price);
            shipInvView = view.findViewById(R.id.ship_inventory);
            marketInvView = view.findViewById(R.id.marketplace_inventory);
            buyButton = view.findViewById(R.id.buyButton);
            sellButton = view.findViewById(R.id.sellButton);
        }
    }
}
