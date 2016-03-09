package com.heb.sbscbd;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SubscriptionItemAdapter extends RecyclerView.Adapter {
    private List<String> data;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
        }
    }

    public SubscriptionItemAdapter(List<String> subscriptionList) {
        data = subscriptionList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subscription_item_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String title = data.get(position);
        View view = holder.itemView;
        TextView textView = (TextView) view.findViewById(R.id.subscription_item_title);
        textView.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
