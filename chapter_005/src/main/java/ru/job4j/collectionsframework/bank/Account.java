package ru.job4j.collectionsframework.bank;

/**
 * Created by Андрей on 04.05.2017.
 */
public class Account {
    /**
     * amount of money.
     */
    private int value;
    /**
     * requisites.
     */
    private long requisites;
    /**
     * constructor.
     * @param value sets amount of money
     * @param requisites sets requisites
     */
    public Account(int value, long requisites) {
        this.requisites = requisites;
        this.value = value;
    }
    /**
     * method returns amount of money.
     * @return amount of money
     */
    public int getValue() {
        return value;
    }
    /**
     * method returns requisites.
     * @return requisites
     */
    public long getRequisites() {
        return requisites;
    }
    /**
     * method sets amount of money.
     * @param value - amount of money
     */
    public void setValue(int value) {
        this.value = value;
    }
    /**
     * method overrides method equals.
     * @param o - variable to compare
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (value != account.value) {
            return false;
        }
        return requisites == account.requisites;
    }
    /**
     * method overrides method hashcode.
     * @return some number
     */
    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (int) (requisites ^ (requisites >>> 32));
        return result;
    }
}
