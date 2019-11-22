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

            diskAccess = (DiskAccess) buffer.remove();                                                  // remove the disk task
            diskAccess.seekTime = ((Math.abs(preTrack - diskAccess.track ) * 0.07) + 0.43) + 11.3;      // calculate the seek time
            preTrack = diskAccess.track;                                                                // update track

            diskAccess.start = System.currentTimeMillis();                                              // update start up
            SleepUtilities.nap(diskAccess.processingTimeFix);                                           // do the task for n(29.3) duration
            diskAccess.endTime = System.currentTimeMillis();                                            // update end time
            diskAccess.professingTime = diskAccess.endTime   - diskAccess.start;                        // find service time
            diskAccess.waitTime = (diskAccess.endTime - diskAccess.createTime) - diskAccess.processingTimeFix;    // find wait time

            diskAccess.turnAroundTime = diskAccess.endTime - diskAccess.createTime;                     // find turnaround time
            DiskAccessStatistic.addTurnaroundTime(diskAccess.turnAroundTime);                           // update total turnaround time
            DiskAccessStatistic.count = DiskAccessStatistic.count + 1;                                  // update amount of time disk get access
            DiskAccessStatistic.addEndTime(diskAccess.endTime);                                         // update total end time
            DiskAccessStatistic.addWaitTime(diskAccess.waitTime);                                       // update total wait time
            DiskAccessStatistic.addProcessingTime(diskAccess.professingTime);                           // update total processing time
            System.out.println("Processed P: " + diskAccess.track + " " + (long)diskAccess.endTime);    // print info
        }
    }
    private Buffer buffer;
}


