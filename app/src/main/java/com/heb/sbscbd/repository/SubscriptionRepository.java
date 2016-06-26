package com.heb.sbscbd.repository;

import com.heb.sbscbd.model.Subscription;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionRepository {

    public List<Subscription> fetchSubscriptions() {
        List<Subscription> currentSubscriptionList = new ArrayList<>();
        currentSubscriptionList.add(new Subscription("CanardPc", 8.50, "02-05-15"));
        currentSubscriptionList.add(new Subscription("Mediapart", 8.50, "02-05-15"));
        currentSubscriptionList.add(new Subscription("Gamekult", 8.50, "02-05-15"));
        currentSubscriptionList.add(new Subscription("VinylClub", 8.50, "02-05-15"));
        currentSubscriptionList.add(new Subscription("OVH", 8.50, "02-05-15"));
        currentSubscriptionList.add(new Subscription("KimmSuffi", 8.50, "02-05-15"));

        return currentSubscriptionList;
    }

    public void addSubscription(Subscription subscription) {

    }
}
