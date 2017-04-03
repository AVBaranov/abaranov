package ru.job4j.start;

import ru.job4j.models.Item;
import java.util.Random;
/**
 * class Tracker.
 */
public class Tracker {
    /**
     * Array of Item objects.
     */
    private Item[] items = new Item[10];
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
        item.setId(String.valueOf(System.currentTimeMillis() + RN.nextInt()));
        this.items[position++] = item;
        return item;
    }
    /**
     * Method search element by id.
     * @param id - identifier
     * @return found element
     */
    public Item findById(String id) {
        Item obs = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id) && items[i] != null) {
                obs = items[i];
                break;
            }
        }
        return obs;
    }
    /**
     * Method return list of requests.
     * @return list of requests
     */
    public Item[] findAll() {
        Item[] mas = new Item[position];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = items[i];
        }
        return mas;
    }
    /**
     * Method update list of requests.
     * @param item - updated request
     */
    public void update(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(item.getName()) && items[i] != null) {
               //items[i].getName() = "str";
                break;
            }
        }
    }
    /**
     * Method delete reequest.
     * @param item - deleted request
     */
    public void delete(Item item) {
        for (int i = 0; i < items.length; i++) {
            Item temp = items[i];
            if (temp != null && temp.getId().equals(item.getId())) {
                items[i] = null;
                position--;
                break;

            }
        }
    }


}
