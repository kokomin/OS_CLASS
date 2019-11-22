//package Semaphores.boundedbuffer;

/**
 * This is the producer thread for the bounded buffer problem.
 */
import java.util.*;

public class Producer implements Runnable {
    public static final int intervalArrivalTime = 50;           // sleep time
    public static double serviceTime = 40;                      // processing time

    public Producer(Buffer b) {
        buffer = b;
        DiskAccessStatistic.startProgramTime = System.currentTimeMillis(); // program start time
    }

    public void run() {
        DiskAccess diskAccess;

        while (true) {
            // 1) generate a disk access request
            diskAccess = new DiskAccess(serviceTime);

            //2) queue (or transmit) the disk access request to the file server
            buffer.insert(diskAccess);
            System.out.println("Created P: " + diskAccess.track + " " + diskAccess.createTime);

            // 3) sleep for an interarrival time N
            SleepUtilities.nap(intervalArrivalTime);
        }
    }
    private Buffer buffer;
}
