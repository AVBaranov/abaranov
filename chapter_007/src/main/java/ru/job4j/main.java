package ru.job4j;

/**
 * Created by Andrey on 27.08.2017.
 */

class cl implements Runnable {

    @Override
    public void run () {

        for (int i = 1; i <= 5; i++) {
            System.out.println("subThread" + i);
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end of subThread");

    }
}

class Run {
    public void start () {
        try {
            System.out.println("start program");
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void end () {
        try {
            Thread.sleep(1000);
            System.out.println("end program");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class main {
    static class test implements Runnable {

        private final String value;

        private final int number;
        public test(String value, int number) {
            this.value = value;
            this.number = number;
        }

        @Override
        public void run() {



            char[] ar = value.toCharArray();
            int count = 0;
            for (int i = 0; i < ar.length; i++) {
                if (ar[i] == ' ') {
                    count++;
                }
            }
            if (number == 1) System.out.println(value.split(" +").length);
            if (number == 2) System.out.println(count);


        }
    }



    public static void main(String[] args) {



//        System.out.println("start program");

        new Run().start();

        String str = new String("sfgdfgh   sdsdg   wfgedgdfg  qwrwerwertwet   sdfgdfg   ghmghjg   ");

        new Thread(new test(str, 1)).start();

        new Thread(new test(str, 2)).start();

        new Run().end();

        Thread t = new Thread(new cl());
        t.start();
        if (!t.isInterrupted()) {
//            t.interrupt();
            System.out.println("sfgvdfgdfg");
        }

        /*new Thread(new cl()).start();
        for (int i = 1; i <= 5; i++) {
            System.out.println("mainThread" + i);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end of mainThread");*/
}
}
