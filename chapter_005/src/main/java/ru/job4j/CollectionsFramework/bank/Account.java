package ru.job4j.CollectionsFramework.bank;

/**
 * Created by Андрей on 04.05.2017.
 */
public class Account {
    private int value;
    private long requisites;
    public Account(int value, long requisites) {
        this.requisites = requisites;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public long getRequisites() {
        return requisites;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
