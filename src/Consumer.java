//package Semaphores.boundedbuffer;

/**
 * This is the consumer thread for the bounded buffer problem.
 */

public class Consumer implements Runnable {
    private int currentTrack;

    public Consumer(Buffer b) {
        buffer = b;
    }

    public void run() {
        DiskAccess diskAccess;

        while (true) {

            diskAccess = (DiskAccess) buffer.remove();
            SleepUtilities.nap((int)(((Math.abs(diskAccess.track - currentTrack) * 0.7) + 0.43) + 11.3));
            currentTrack = diskAccess.track;

            diskAccess.processingTimeStartTime = System.currentTimeMillis();               // record start time
            SleepUtilities.nap((int)diskAccess.processingTimeFix);                            // do the task for n duration
            diskAccess.processingTimeEndTime = System.currentTimeMillis();                 // record end time
            diskAccess.processingTime = diskAccess.processingTimeEndTime - diskAccess.processingTimeStartTime;   // calculate the time that it exactly running


            diskAccess.completeTime = System.currentTimeMillis();                               // set the completion because ALL tasks are done at this point
            diskAccess.turnAroundTime = diskAccess.completeTime - diskAccess.createTime;

//            DiskAccessStatistic.mTotalTime = DiskAccessStatistic.mTotalTime + diskAccess.turnAroundTime;
            diskAccess.waitTime = diskAccess.turnAroundTime - diskAccess.processingTime; // when program just wait without doing anything



            DiskAccessStatistic.addProcessingTime(diskAccess.processingTime);
            DiskAccessStatistic.addTurnaroundTime(diskAccess.turnAroundTime);
            DiskAccessStatistic.addWaitTimeTotal(diskAccess.waitTime);

            DiskAccessStatistic.count = DiskAccessStatistic.count + 1;
//            DiskAccessStatistic.evalThroughPut(diskAccess.createTime, diskAccess.completeTime);
//            DiskAccessStatistic.evalCPU_usage();


//            System.out.println("avg service time " + diskAccess.processingTime);
//            DiskAccessStatistic.displaySta();







//            System.out.println("Consumer napping");
//            SleepUtilities.nap();
//
//            // consume an item from the buffer
//            System.out.println("Consumer wants to consume.");
//
//            message = (Date) buffer.remove();
//            System.out.println("Consumer received message:" + message);
        }
    }
    private Buffer buffer;
}


