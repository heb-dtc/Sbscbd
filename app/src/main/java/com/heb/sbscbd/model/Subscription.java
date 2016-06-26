package com.heb.sbscbd.model;

import org.joda.time.DateTime;

public class Subscription {
    private final String name;
    private final double price;
    private final String startDate;

    public Subscription(String name, double price, String startDate) {
        this.name = name;
        this.price = price;
        this.startDate = startDate;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public DateTime getStartDateTime() {
        return DateTime.parse(startDate);
    }

    public String getNextPayementDate() {
        return "03-04-16";
    }
}
