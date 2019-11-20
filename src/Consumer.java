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
//            SleepUtilities.nap((int)(((Math.abs(diskAccess.track - currentTrack) * 0.7) + 0.43) + 11.3));
            //SleepUtilities.nap((int)(((Math.abs(preTrack - diskAccess.track ) * 0.7) + 0.43)));
            diskAccess.seekTime = (Math.abs(preTrack - diskAccess.track ) * 0.07) + 0.43;
            preTrack = diskAccess.track;

            //diskAccess.processingTimeStartTime = System.currentTimeMillis();               // record start time
            SleepUtilities.nap(diskAccess.processingTimeFix);                            // do the task for n(29.3) duration

            long completeTime = System.currentTimeMillis();                              // record when all task is done
            diskAccess.endTime = completeTime + diskAccess.processingTimeFix;


//            diskAccess.waitTime = diskAccess.processingTime - diskAccess.createTime - diskAccess.processingTimeFix; // when program just wait without doing anything
            diskAccess.waitTime = (diskAccess.endTime - diskAccess.createTime) - diskAccess.processingTimeFix;



            diskAccess.turnAroundTime = diskAccess.endTime - diskAccess.createTime;
            DiskAccessStatistic.addTurnaroundTime(diskAccess.turnAroundTime);

            DiskAccessStatistic.count = DiskAccessStatistic.count + 1;
            DiskAccessStatistic.addEndTime(diskAccess.endTime);
            DiskAccessStatistic.addWaitTime(diskAccess.waitTime);
            DiskAccessStatistic.addProcessingTime(diskAccess.processingTimeFix);







//            diskAccess.processingTime = diskAccess.processingEndTime + diskAccess.processingTimeFix;   // calculate the time that it exactly running
//            //diskAccess.processingTime = diskAccess.processingTimeEndTime + diskAccess.processingTimeFix;   // calculate the time that it exactly running
//            DiskAccessStatistic.addProcessingTime(diskAccess.processingTime);
//
//
//            //diskAccess.completeTime = System.currentTimeMillis();                               // set the completion because ALL tasks are done at this point
//            diskAccess.turnAroundTime = diskAccess.processingTime - diskAccess.createTime;
//



//            DiskAccessStatistic.addProcessingTime(diskAccess.processingTime);
//            DiskAccessStatistic.addTurnaroundTime(diskAccess.turnAroundTime);
//            DiskAccessStatistic.addWaitTimeTotal(diskAccess.waitTime);


        }
    }
    private Buffer buffer;
}


