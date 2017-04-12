package ru.job4j.start;

import ru.job4j.models.Item;

/**
 * main class.
 */
public class MenuTracker {
    /**
     * input object.
     */
    private Input input;
    /**
     * tracker object.
     */
    private Tracker tracker;
    /**
     * array of UserAction objects.
     */
    private UserAction[] actions = new UserAction[7];
    /**
     * constructor.
     * @param input sets input object
     * @param tracker sets tracker object
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }
    /**
     * method fill array of actions.
     */
    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowAll();
        this.actions[2] = new MenuTracker.EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new Exit();
    }
    /**
     * method returns array of valid numbers for actions.
     * @return array of valid numbers
     */
    int[] count() {
        int[] array = new int[actions.length];
        for (int i = 0; i < actions.length; i++) {
            array[i] = i;
        }
        return array;
    }
    /**
     * method select action.
     * @param key sets user's action
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    /**
     * method show start information.
     */
    public void show() {
        for (UserAction action: this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        /*for(int i=0; i<actions.length; i++) {
            UserAction add = new AddItem();
            if (add != null) {
                System.out.println(add.info());
                break;
            }
        }*/
    }
    /**
     * class for adding items.
     */
    private class AddItem implements UserAction {
        /**
         * method determines action.
         * @return key
         */
       public int key() {
            return 0;
        }
        /**
         * method adds item.
         * @param input - input object
         * @param tracker - tracker object
         */
        public void execute(Input input, Tracker tracker) {
            System.out.print("Enter your name: ");
            String name = input.ask();
            System.out.print("Enter task's description: ");
            String desc = input.ask();
            Item it1 = new Item(name, desc);
            tracker.add(it1);
        }
        /**
         * method show information about action.
         * @return information
         */
        public String info() {
           return String.format("%s. %s", this.key(), "add new item");
        }
    }
    /**
     * class for show all items.
     */
    private static class ShowAll implements UserAction {
        /**
         * method determines action.
         * @return key
         */
        public int key() {
            return 1;
        }
        /**
         * method adds item.
         * @param input - input object
         * @param tracker - tracker object
         */
        public void execute(Input input, Tracker tracker) {
            if (tracker.findAll().length != 0) {
                System.out.println("Your items:");
                for (int i = 0; i < tracker.findAll().length; i++) {
                    System.out.println(String.format("%s %s %s", tracker.findAll()[i].getName(), tracker.findAll()[i].getDescription(), /*tracker.findAll()[i].getCreate(),*/tracker.findAll()[i].getId()));
                    Item item = tracker.findAll()[i];
                }
            } else {
                System.out.println("Nothing to display");
            }
        }
        /**
         * method show information about action.
         * @return information
         */
        public String info() {
            return String.format("%s. %s", this.key(), "show all items");
        }
    }
    /**
     * class for edit item.
     */
    private static class EditItem implements UserAction {
        /**
         * method determines action.
         * @return key
         */
        public int key() {
            return 2;
        }
        /**
         * method adds item.
         * @param input - input object
         * @param tracker - tracker object
         */
        public void execute(Input input, Tracker tracker) {
            System.out.print("Enter item's id to replace: ");
            String id = input.ask();
            boolean b = true;
            for (int i = 0; i < tracker.findAll().length; i++) {
                if (tracker.findAll()[i].getId().equals(id)) {
                    System.out.print("Enter new name: ");
                    String name = input.ask();
                    System.out.print("Enter new description: ");
                    String desc = input.ask();
                    b = false;
                    tracker.update(id, new Item(name, desc));
                    break;
                }
            }
            if (b) {
                System.out.println("You entered incorrect value!");
            }
        }
        /**
         * method show information about action.
         * @return information
         */
        public String info() {
            return String.format("%s. %s", this.key(), "edit item");
        }
    }
    /**
     * class for delete item.
     */
    class DeleteItem implements UserAction {
        /**
         * method determines action.
         * @return key
         */
        public int key() {
            return 3;
        }
        /**
         * method adds item.
         * @param input - input object
         * @param tracker - tracker object
         */
        public void execute(Input input, Tracker tracker) {
            System.out.print("Enter your name: ");
            String name = input.ask();
            System.out.print("Enter task's description: ");
            String desc = input.ask();
            Item temp = null;
            boolean b = false;
            for (int i = 0; i < tracker.findAll().length; i++) {
                if (name.equals(tracker.findAll()[i].getName()) && desc.equals(tracker.findAll()[i].getDescription())/* && create == tracker.findAll()[i].getCreate()*/) {
                    temp = tracker.findAll()[i];
                    b = true;
                    break;
                }
            }
            if (b) {
                tracker.delete(temp);
                System.out.println("Done");
            } else {
                System.out.println("You entered incorrect value!");
            }
        }
        /**
         * method show information about action.
         * @return information
         */
        public String info() {
            return String.format("%s. %s", this.key(), "delete item");
        }
    }
    /**
     * class for searching item by id.
     */
    private static class FindById implements UserAction {
        /**
         * method determines action.
         * @return key
         */
        public int key() {
            return 4;
        }
        /**
         * method adds item.
         * @param input - input object
         * @param tracker - tracker object
         */
        public void execute(Input input, Tracker tracker) {
            System.out.print("Enter ID: ");
            String temp = input.ask();
            Item it = tracker.findById(temp);
            if (it != null) {
                System.out.println(String.format("%s %s %s", it.getName(), it.getDescription(), /* it.getCreate(),*/ it.getId()));
            } else {
                System.out.println("You entered incorrect value!");
            }
        }
        /**
         * method show information about action.
         * @return information
         */
        public String info() {
            return String.format("%s. %s", this.key(), "find item by id");
        }
    }
    /**
     * class for searching items by name.
     */
    private class FindByName implements UserAction {
        /**
         * method determines action.
         * @return key
         */
        public int key() {
            return 5;
        }
        /**
         * method adds item.
         * @param input - input object
         * @param tracker - tracker object
         */
        public void execute(Input input, Tracker tracker) {
            System.out.print("Enter your name: ");
            String name = input.ask();
            if (tracker.findByName(name).length == 0) {
                System.out.println("You entered incorrect value!");
            }
            for (int i = 0; i < tracker.findByName(name).length; i++) {
                System.out.println(String.format("%s %s %s", tracker.findByName(name)[i].getName(), tracker.findByName(name)[i].getDescription(), /*tracker.findByName(name)[i].getCreate(), */tracker.findByName(name)[i].getId()));
            }
        }
        /**
         * method show information about action.
         * @return information
         */
        public String info() {
            return String.format("%s. %s", this.key(), "find item by name");
        }
    }
    /**
     * class for searching items by name.
     */
    private class Exit implements UserAction {
        /**
         * method determines action.
         * @return key
         */
        public int key() {
            return 6;
        }
        /**
         * method adds item.
         * @param input - input object
         * @param tracker - tracker object
         */
        public void execute(Input input, Tracker tracker) {
            return;
        }
        /**
         * method show information about action.
         * @return information
         */
        public String info() {
            return String.format("%s. %s", this.key(), "exit");
        }
    }
}
