//package Semaphores.boundedbuffer;

/**
 * This is the producer thread for the bounded buffer problem.
 */
import java.util.*;

public class Producer implements Runnable {
    public static final int intervalArrivalTime = 60;
    public static double serviceTime = 29.3;

    public Producer(Buffer b) {
        buffer = b;
        DiskAccessStatistic.startProgramTime = System.currentTimeMillis();
    }

    public void run() {
        DiskAccess diskAccess;

        while (true) {
            // 1) generate a disk access request
            diskAccess = new DiskAccess(serviceTime);

            //2) queue (or transmit) the disk access request to the file server
            buffer.insert(diskAccess);

            // 3) sleep for an interarrival time N
            SleepUtilities.nap(intervalArrivalTime);
        }
    }
    private Buffer buffer;
}
