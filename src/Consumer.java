//package Semaphores.boundedbuffer;

/**
 * This is the consumer thread for the bounded buffer problem.
 */

public class Consumer implements Runnable {
    private int preTrack;


    public Consumer(Buffer b) {
        buffer = b;
    }

    public void run() {
        DiskAccess diskAccess;

        while (true) {

            diskAccess = (DiskAccess) buffer.remove();
            diskAccess.seekTime = (Math.abs(preTrack - diskAccess.track ) * 0.07) + 0.43;
            preTrack = diskAccess.track;

            SleepUtilities.nap(diskAccess.processingTimeFix);                               // Do the task for n(29.3) duration

            long completeTime = System.currentTimeMillis();                                 // Record when all task is done
            diskAccess.endTime = completeTime + diskAccess.processingTimeFix;


            diskAccess.waitTime = (diskAccess.endTime - diskAccess.createTime) - diskAccess.processingTimeFix;

            diskAccess.turnAroundTime = diskAccess.endTime - diskAccess.createTime;
            DiskAccessStatistic.addTurnaroundTime(diskAccess.turnAroundTime);

            DiskAccessStatistic.count = DiskAccessStatistic.count + 1;                      // Update amount of time disk get access
            DiskAccessStatistic.addEndTime(diskAccess.endTime);
            DiskAccessStatistic.addWaitTime(diskAccess.waitTime);
            DiskAccessStatistic.addProcessingTime(diskAccess.processingTimeFix);

            System.out.println("Processed P: " + diskAccess.track + " " + (long)diskAccess.endTime);
        }
    }
    private Buffer buffer;
}


