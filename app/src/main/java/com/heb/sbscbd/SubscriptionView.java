package com.heb.sbscbd;

import com.heb.sbscbd.model.Subscription;

import java.util.List;

public interface SubscriptionView {
    void displaySubscriptions(List<Subscription> subscriptions);
}
