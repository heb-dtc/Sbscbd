package com.heb.sbscbd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.heb.sbscbd.model.Subscription;
import com.heb.sbscbd.presenter.SubscriptionPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SubscriptionView {

    private RecyclerView subscriptionListView;
    private SubscriptionPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        subscriptionListView = (RecyclerView) findViewById(R.id.subscription_list_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        subscriptionListView.setLayoutManager(layoutManager);

        presenter = new SubscriptionPresenter(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddSubscriptionDialog dialog = new AddSubscriptionDialog();
                dialog.show(getFragmentManager(), "add_subscription_dialog");
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        presenter.fetchSubscriptions();
    }

    @Override
    public void displaySubscriptions(List<Subscription> subscriptions) {
        RecyclerView.Adapter adapter = new SubscriptionItemAdapter(subscriptions);
        subscriptionListView.setAdapter(adapter);
    }
}
