package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Andrey on 17.09.2017.
 */

class SimpleThread extends Thread {

    private Bomberman bomberman;
//    private Lock lock;

    public SimpleThread(Bomberman bomberman) {
        this.bomberman = bomberman;
//        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            bomberman.move();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Bomberman {

    final private ReentrantLock[][] board;

    private int countX = 0;
    private int countY = 0;

    public Bomberman(int x, int y) {
        this.board = new ReentrantLock[x][y];
    }

    public void createPlayer() {
        if (countX >= board.length) {
            countY++;
        }
        this.board[countX++][countY].lock();
    }




    public void move() throws Exception {
        this.board[countX][countY].unlock();
        this.board[countX++][countY++].lock();
    }



    /*public void wrongmove() throws Exception {
        for (int i = 0; i < board[i].length; i++) {
            for (int j = 0; j < board[j].length; j++) {
                if (board[i][j].tryLock(500, TimeUnit.SECONDS)) {
                    occupyCell(board[i][j]);
                }
            }
        }
    }

    public void occupyCell(Lock lock) {
        lock.lock();
    }*/

}
