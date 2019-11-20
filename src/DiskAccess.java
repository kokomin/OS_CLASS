public class DiskAccess {
    public long createTime;              // start time when disk create
    public long completeTime;           // end time when everything is done (at the every end of consumer?)
    public long processingTimeStartTime;   // start when producer put disk in buffer
    public long processingTimeEndTime;     // end when consumer finish sleep and process the disk
    public double processingTimeFix;          // EXPECTED amount of time producer want to run (fix number, provide by user)
    public double processingTime;      // realEnd - realStart
    public int track;                   // generate when disk first created
    public long turnAroundTime;         // end - start (end when consumer finish processing the disk, start time when disk is created)
    public double waitTime;             // turnAroundTime – realServiceTime (time disk is waiting without doing anything)


    public DiskAccess(double pServiceTime) {
        track = (int)(Math.random() * 499);
        createTime = System.currentTimeMillis();
        processingTimeFix = pServiceTime;
    }

}
