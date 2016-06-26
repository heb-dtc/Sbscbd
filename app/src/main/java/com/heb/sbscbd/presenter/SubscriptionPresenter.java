package com.heb.sbscbd.presenter;

import com.heb.sbscbd.SubscriptionView;
import com.heb.sbscbd.model.Subscription;
import com.heb.sbscbd.repository.SubscriptionRepository;

import java.util.List;

public class SubscriptionPresenter {

    private SubscriptionRepository repository;
    private SubscriptionView view;

    public SubscriptionPresenter(SubscriptionView view) {
        repository = new SubscriptionRepository();
        this.view = view;
    }

    public void fetchSubscriptions() {
        List<Subscription> subscriptions = repository.fetchSubscriptions();

        if (view != null) {
            view.displaySubscriptions(subscriptions);
        }
    }
}
