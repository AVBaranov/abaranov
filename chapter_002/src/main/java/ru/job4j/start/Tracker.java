package ru.job4j.start;

import ru.job4j.models.Item;
import java.util.Random;
import java.util.Arrays;
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
        if (item == null) {
            System.out.println("Wrong parametr! Exiting...");
            return null;
        }
        item.setId(String.valueOf(/*System.currentTimeMillis() + RN.nextInt()*/item.getDescription()) + item.getName());
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
            if (items[i] != null && items[i].getId().equals(id)) {
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
     * @param id - id of replaced item
     */
    public void update(String id, Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i].setName(item.getName());
                items[i].setDescription(item.getDescription());
                //items[i].setCreate(item.getCreate());
                items[i].setId(items[i].getCreate() + items[i].getName());
                break;
            }
        }
    }
    /**
     * Method delete reequest.
     * @param item - deleted request
     */
    public void delete(Item item) {
        boolean b = true;
        for (int i = 0; i < items.length; i++) {
            Item temp = items[i];
            if (temp != null && temp.getId().equals(item.getId())) {
                for (int j = i; j < items.length - 1; j++) {
                    Item buf = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = buf;
                }
                position--;
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
    public Item[] findByName(String key) {
        int counter = 0;
        Item obs = null;
        Item[] array = new Item[items.length];
        int j = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && key.equals(items[i].getName())) {
                array[j] = items[i];
                counter++;
                j++;
            }
        }
        return Arrays.copyOf(array, counter);
    }


}
