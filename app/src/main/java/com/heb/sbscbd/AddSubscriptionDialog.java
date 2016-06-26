package com.heb.sbscbd;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import com.heb.sbscbd.model.Subscription;
import com.heb.sbscbd.presenter.AddSubscriptionPresenter;

public class AddSubscriptionDialog extends DialogFragment implements AddSubscriptionView {

    private EditText nameBox;
    private EditText priceBox;
    private EditText startDateBox;

    private AddSubscriptionPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.add_subscription_dialog, null);
        Button addActionButton = (Button) root.findViewById(R.id.add_action);
        Button cancelActionButton = (Button) root.findViewById(R.id.cancel_action);
        nameBox = (EditText) root.findViewById(R.id.subscription_name);
        priceBox = (EditText) root.findViewById(R.id.subscription_price);
        startDateBox = (EditText) root.findViewById(R.id.subscription_start_date);

        presenter = new AddSubscriptionPresenter(this);

        addActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addSubscription(nameBox.getText().toString(), priceBox.getText().toString(), startDateBox.getText().toString());
            }
        });

        cancelActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        return root;
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(), "Input are invalid", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finish() {
        dismiss();
    }
}
