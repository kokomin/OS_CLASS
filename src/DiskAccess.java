public class DiskAccess {
    public long createTime;                                 // start time when disk create
    public double endTime;                                  // end time when everything is done (at the every end of consumer)
    public double processingTimeFix;                        // EXPECTED amount of time producer want to run (fix number, provide by user)
    public int track;                                       // generate when disk first created
    public double turnAroundTime;                           // end - start (end when consumer finish processing the disk, start time when disk is created)
    public double waitTime;                                 // wait time – realServiceTime (time disk is waiting without doing anything)
    public double seekTime;                                 // time to move the arm to the appropriate track


    public DiskAccess(double pServiceTime) {
        track = (int)(Math.random() * 499);
        createTime = System.currentTimeMillis();
        processingTimeFix = pServiceTime;
    }

}
