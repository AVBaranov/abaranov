package ru.job4j.collectionsframework.xml;

/**
 * Created by Андрей on 22.08.2017.
 */
public class Order {
    int volume;

    long orderId;

    public Order(int volume, long orderId) {
        this.volume = volume;
        this.orderId = orderId;
    }

    public int getVolume() {
        return volume;
    }

    public long getOrderId() {
        return orderId;
    }
}
