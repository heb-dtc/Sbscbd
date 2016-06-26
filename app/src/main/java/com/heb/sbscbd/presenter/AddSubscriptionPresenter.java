package com.heb.sbscbd.presenter;

import com.heb.sbscbd.AddSubscriptionView;
import com.heb.sbscbd.model.Subscription;
import com.heb.sbscbd.repository.SubscriptionRepository;

public class AddSubscriptionPresenter {

    private AddSubscriptionView view;
    private SubscriptionRepository repository;

    public AddSubscriptionPresenter(AddSubscriptionView view) {
        repository = new SubscriptionRepository();
        this.view = view;
    }

    public void addSubscription(String name, String price, String startDate) {
        if (validateData(name, price, startDate)) {
            Subscription subscription = new Subscription(name, Double.valueOf(price), startDate);
            repository.addSubscription(subscription);

            if (view != null) {
                view.finish();
            }
        } else {
            if (view != null) {
                view.showError();
            }
        }
    }

    private boolean validateData(String name, String price, String startDate) {
        return !name.isEmpty() && priceIsValid(price) && startDateIsValid(startDate);
    }

    //TODO: implement validator
    private boolean startDateIsValid(String startDate) {
        return true;
    }

    //TODO: fix regex
    private boolean priceIsValid(String price) {
        return price.matches("[0-9]+[.,]?|[0-9]*[.,][0-9]+");
    }
}
