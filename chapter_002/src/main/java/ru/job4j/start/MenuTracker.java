package ru.job4j.start;

import ru.job4j.models.Item;

/**
 * main class.
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    public MenuTracker(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
}
    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowAll();
        this.actions[2] = new MenuTracker.EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
    }
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
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
    private class AddItem implements UserAction {
       public int key() {
            return 0;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.print("Enter your name: ");
            String name = input.ask();
            System.out.print("Enter task's description: ");
            String desc = input.ask();
            Item it1 = new Item(name, desc);
            tracker.add(it1);
        }
        public String info() {
           return String.format("%s. %s", this.key(), "add new item");
        }
    }
    private static class ShowAll implements UserAction {
        public int key() {
            return 1;
        }
        public void execute(Input input, Tracker tracker) {
            if (tracker.findAll().length != 0) {
                System.out.println("Your items:");
                for (int i = 0; i < tracker.findAll().length; i++) {
                    System.out.println(String.format("%s %s %s", tracker.findAll()[i].getName(), tracker.findAll()[i].getDescription(), /*tracker.findAll()[i].getCreate(),*/ tracker.findAll()[i].getId()));
                    Item item = tracker.findAll()[i];
                }
            } else {
                System.out.println("Nothing to display");
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "show all items");
        }
    }
    private static class EditItem implements UserAction {
        public int key() {
            return 2;
        }
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
        public String info() {
            return String.format("%s. %s", this.key(), "edit item");
        }
    }
    class DeleteItem implements UserAction{
        public int key() {
            return 3;
        }
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
        public String info() {
            return String.format("%s. %s", this.key(), "delete item");
        }
    }
    private static class FindById implements UserAction {
        public int key() {
            return 4;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.print("Enter ID: ");
            String temp = input.ask();
            Item it = tracker.findById(temp);
            if (it != null) {
                System.out.println(String.format("%s %s %s", it.getName(), it.getDescription(),/* it.getCreate(),*/ it.getId()));
            } else {
                System.out.println("You entered incorrect value!");
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "find item by id");
        }
    }
    private class FindByName implements UserAction {
        public int key() {
            return 5;
        }
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
        public String info() {
            return String.format("%s. %s", this.key(), "find item by name");
        }
    }
}
