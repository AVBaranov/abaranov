package ru.job4j.start;

import ru.job4j.models.*;
import java.util.*;
/**
 * Created by Andrey on 31.03.2017.
 */
public class Tracker {
    private Item[] items = new Item[10];
    private int position=0;
    private static final Random RN = new Random();
    /*public Item[] getItem() {
        return this.items;
    }*/
    public Item add(Item item) {
        item.setId(String.valueOf(System.currentTimeMillis() + RN.nextInt()));
        this.items[position++]=item;
        return item;
    }
    public Item findById(String id) {
        Item obs = null;
        for(int i=0; i<items.length; i++) {
            if(items[i].getId().equals(id) && items[i]!=null) {
                obs=items[i];
                break;
            }
        }
        return obs;
    }

    public Item[] findAll() {
        Item[] mas = new Item[position];
        for(int i=0; i < mas.length; i++) {
            mas[i] = items[i];
        }
        return mas;
    }
    public void update(Item item) {
        for(int i=0; i<items.length; i++) {
            if(items[i].getName().equals(item.getName()) && items[i]!=null) {
                items[i].name="name2";
                break;
            }
        }
    }
    public void delete(Item item) {
        for(int i=0; i<items.length; i++) {
            Item temp = items[i];
            if(temp.getId().equals(item.getId()) && temp != null) {
                items[i]=null;
                position--;
                break;
            }
        }
    }


}
