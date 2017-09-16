package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Andrey on 17.09.2017.
 */

class SimpleThread extends Thread {

    private Bomberman object;
    private Lock lock;

    public SimpleThread(Bomberman object) {
        this.object = object;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {

    }
}

public class Bomberman {

        final private ReentrantLock[][] board;

        public Bomberman(ReentrantLock[][] board) {
            this.board = board;
        }

        public void occupyCell(Lock lock) {
            lock.lock();
        }

        public void move() throws Exception {
            for (int i = 0; i < board[i].length; i++) {
                for (int j = 0; j < board[j].length; j++) {
                    if (board[i][j].tryLock(500, TimeUnit.SECONDS)) {
                        occupyCell(board[i][j]);
                    }
                }
            }
        }

}
