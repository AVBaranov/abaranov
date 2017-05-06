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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (value != account.value) return false;
        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (int) (requisites ^ (requisites >>> 32));
        return result;
    }
}
