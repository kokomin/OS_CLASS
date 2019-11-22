public class DiskAccessStatistic {

    // max time of all variable
    public static double maxWaitTime = 0;
    public static double maxProcessingTime = 0;
    public static double maxTurnAroundTime= 0;
    public static double maxEndTime;

    // tracker information
    public static int count;
    public static long startProgramTime;
    public static long endProgramTime;

    // disk run time
    public static double processingTimeTotal;
    public static double turnaroundTimeTotal;
    public static double waitTimeTotal;
    public static double endTimeTotal;

    /**
     * doAvgProcessingTime():
     * updated processing time
     * @return average processing time
     */
    public static double doAvgProcessingTime() {
        if (count >= 1) {
            return processingTimeTotal / count;
        } else {
            return -1;
        }
    }

    /**
     * doAvgTurnAroundTime()
     * calculate average turn around time
     * @return average turn around
     */
    public static double doAvgTurnAroundTime() {
        if (count >= 1) {
            return turnaroundTimeTotal / count;
        } else {
            return -1;
        }
    }

    /**
     * doAvgWaitTime():
     * calculate average wait time
     * @return average wait time
     */
    public static double doAvgWaitTime() {
        if (count >= 1) {
            return waitTimeTotal / count;
        } else {
            return -1;
        }
    }

    /**
     * addProcessingTime():
     * add service time into total service time
     * and update max service time
     * @param time
     */
    public static void addProcessingTime(double time){
        processingTimeTotal = processingTimeTotal + time;
        if (time > maxProcessingTime) {
            maxProcessingTime = time;
        }
    }

    /**
     * addTurnaroundTime():
     * add turnaround time into total turnaround time
     * @param time
     */
    public static void addTurnaroundTime(double time){
        turnaroundTimeTotal = turnaroundTimeTotal + time;
        if (time > maxTurnAroundTime) {
            maxTurnAroundTime = time;
        }
    }

    /**
     * addWaitTime():
     * add wait time into total wait time
     * @param time
     */
    public static void addWaitTime(double time){
        waitTimeTotal = waitTimeTotal + time;
        if (time > maxWaitTime) {
            maxWaitTime = time;
        }
    }

    /**
     * addEndTime():
     * add end time into total end time
     * @param time
     */
    public static void addEndTime(double time) {
        endTimeTotal = endTimeTotal + time;
        if (time > maxEndTime) {
            maxEndTime = time;
        }
    }

    /**
     * doThroughPut():
     * calculate through put
     * @return amount of through put
     */
    public static double doThroughPut() {
        double totalProgramRunTime = endProgramTime - startProgramTime;
        return (count / totalProgramRunTime) * 100000.0;

    }

    /**
     * doCPU_usage():
     * update cpu usage time
     * @return percentage of cpu usage
     */
    public static double doCPU_usage() {
        double totalProgramRunTime = endProgramTime - startProgramTime;
        return (processingTimeTotal / totalProgramRunTime) * 100;
    }

    /**
     * print all static info
     */
    public static void displaySta() {
        System.out.println("\n\n");
        System.out.println("average service time: " + doAvgProcessingTime() /100 + " milliseconds");
        System.out.println("max service time: " + maxProcessingTime /100 + " milliseconds");
        System.out.println("average turn around time " + doAvgTurnAroundTime()/100 + " milliseconds");
        System.out.println("max turn around time " + maxTurnAroundTime/100 + " milliseconds");
        System.out.println("average wait time " + doAvgWaitTime()/10000 + " milliseconds");
        System.out.println("max wait time " + maxWaitTime/10000 + " milliseconds");
        System.out.println("end time " + endProgramTime);
        System.out.println("start time " + startProgramTime);
        System.out.println("processor utilization: " + doCPU_usage() + " %");
        System.out.println("Throughput: " + doThroughPut());
        System.out.println("---------------------------");


    }

}
