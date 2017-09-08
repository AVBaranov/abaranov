package ru.job4j;

/**
 * Created by Andrey on 27.08.2017.
 */

class cl implements Runnable {

    private final String str;
    public cl(String str) {
        this.str = str;
    }

    @Override
    public void run () {

        for (int i = 1; i <= 5; i++) {
            System.out.println(String.format("%sThread%s", str, i));
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("end of %sThread", str));

    }
}

class Delay {
    public void start () {
        try {
            System.out.println("start program");
            Thread.sleep(4000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void end () {
        try {
            Thread.sleep(4000);
            System.out.println("end program");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


 class ReadText implements Runnable {

    private final String value;

    private final int number;
    public ReadText(String value, int number) {
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

class RunThreads {
    final long EXECUTION_TIME = 1000;
    private final String text;
    public RunThreads(String text) {
        this.text = text;
    }
    public void run() {
        new Delay().start();

        long begin = System.currentTimeMillis();

        Thread thread1 = new Thread(new ReadText(text, 1));
        thread1.start();

        Thread thread2 = new Thread(new ReadText(text, 2));
        thread2.start();

        new Delay().end();

        long end = System.currentTimeMillis();

        if (EXECUTION_TIME <= (end - begin)) {
            thread1.interrupt();
            thread2.interrupt();
            System.out.println("zdfsdf");
        }
    }
}

public class main {


    public static void main(String[] args) {

        new RunThreads("sfgdfgh   sdsdg   wfgedgdfg  qwrwerwertwet   sdfgdfg   ghmghjg   ").run();


        //        ExecutorService exs = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        System.out.println(Runtime.getRuntime().availableProcessors());

        /*String str = new String("sdhdfghdfg");

        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println(str.length());
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println(str.length() + 10);
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

}
}
