package ru.job4j.start;

import ru.job4j.models.Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Arrays;
/**
 * class Tracker.
 */
public class Tracker {
    /**
     * Array of Item objects.
     */
    private ArrayList<Item> items = new ArrayList<>();
    /**
     * Describes position in array.
     */
    private int position = 0;
    /**
     * Random number.
     */
    private static final Random RN = new Random();
    /**
     * Method add new element to array.
     * @param item - addition
     * @return added element
     */
    public Item add(Item item) {
        if (item == null) {
            System.out.println("Wrong parametr! Exiting...");
            return null;
        }
        item.setId(String.valueOf(item.getDescription()) + item.getName());
        this.items.add(item);
        return item;
    }
    /**
     * Method search element by id.
     * @param id - identifier
     * @return found element
     */
    public Item findById(String id) {
        Item obs = null;
        Iterator<Item> iter = items.iterator();
        int k = 0;
        int j = 0;
        for (Item it : items) {
            if (items.get(k) != null && items.get(j++).getId().equals(id)) {
                obs = items.get(k);
                break;
            }
            k++;
        }
        return obs;
    }
    /**
     * Method return list of requests.
     * @return list of requests
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> fn = new ArrayList<>();
        fn.addAll(items);
        return fn;
    }
    /**
     * Method update list of requests.
     * @param item - updated request
     * @param id - id of replaced item
     */
    public void update(String id, Item item) {
        int k = 0;
        int j = 0;
        for (Item it : items) {
            if (items.get(k) != null && items.get(j++).getId().equals(id)) {
                items.set(k, item);
                break;
            }
            k++;
        }
    }
    /**
     * Method delete reequest.
     * @param item - deleted request
     */
    public void delete(Item item) {
        boolean b = true;
        int k = 0;
        int j = 0;
        /*for (Item it : items) {
            if (items.get(k) != null && items.get(j++).getId().equals(item.getId())) {
                items.remove(k);
                b = false;
                break;
            }
            k++;
        }*/
        for (Item it : items) {
            if (it != null && it.getId().equals(item.getId())) {
                items.remove(k);
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println("не существующий элемент");
        }
    }
    /**
     * Method search element by name.
     * @param key - name
     * @return new array
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> its = new ArrayList<>();
        int k = 0;
        int j = 0;
        for (Item it : items) {
            if (items.get(k) != null && items.get(j++).getName().equals(key)) {
                its.add(it);
            }
            k++;
        }
        return its;
    }


}
