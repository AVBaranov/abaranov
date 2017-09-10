package ru.job4j.wait_notify;

import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * Created by Андрей on 06.09.2017.
 */




public class ProducerCustomer {

    SimpleLock sl = new SimpleLock();

    private SimpleQueue<String> queue = new SimpleQueue<>();

    private final Object lock = new Object();

    public void getElement() throws InterruptedException{
        synchronized (this.lock) {
            if (this.queue.isEmpty()) {
                System.out.println("no items available");
//                lock.wait();
                sl.lock(this.lock);
            }
            System.out.println(String.format("geting element: %s", this.queue.get()));
        }
    }


    public void addElement(String element) {
        synchronized (this.lock) {
            this.queue.add(element);
            if (!this.queue.isEmpty()) {
//                this.lock.notify();
                sl.unlock(this.lock);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ProducerCustomer blockingWork = new ProducerCustomer();
        Thread customer = new Thread() {
            @Override
            public void run() {
                try {

                    blockingWork.getElement();
                    blockingWork.getElement();
                    blockingWork.getElement();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread customer2 = new Thread() {
            @Override
            public void run() {
                try {
                    blockingWork.getElement();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread producer = new Thread() {
            @Override
            public void run() {
                blockingWork.addElement("one");
                blockingWork.addElement("two");
                blockingWork.addElement("three");
                blockingWork.addElement("four");
            }
        };
        producer.start();
        customer.start();
        customer2.start();
        customer.join();
        producer.join();


    }

}
