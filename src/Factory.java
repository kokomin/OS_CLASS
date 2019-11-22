//package Semaphores.boundedbuffer;

import java.util.concurrent.TimeUnit;

/**
 * This creates the buffer and the producer and consumer threads.
 *
 */
public class Factory {

    public static void main(String args[]) {
        Buffer server = new BoundedBuffer();

        int sleepTime = 60;

        // now create the producer and consumer threads
        Thread producerThread = new Thread(new Producer(server));
        Thread consumerThread0 = new Thread(new Consumer(server));
        Thread consumerThread1 = new Thread(new Consumer(server));
//        Thread consumerThread2 = new Thread(new Consumer(server));
        producerThread.start();
        consumerThread0.start();
        consumerThread1.start();
//        consumerThread2.start();



        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // stop program time
        DiskAccessStatistic.endProgramTime = System.currentTimeMillis();

        producerThread.stop();
        consumerThread0.stop();
        consumerThread1.stop();



        DiskAccessStatistic.displaySta();
    }
}
