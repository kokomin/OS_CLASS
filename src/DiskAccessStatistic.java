public class DiskAccessStatistic {
    public static double maxWaitTime = 0;
    public static double maxProcessingTime = 0;
    public static double maxTurnAroundTime= 0;
    public static double maxEndTime;


    public static int count;
    public static long startProgramTime;
    public static long endProgramTime;


    // total time
    public static double processingTimeTotal;
    public static double turnaroundTimeTotal;
    public static double waitTimeTotal;
    public static double endTimeTotal;




    public static double doAvgProcessingTime() {
        if (count >= 1) {
            return processingTimeTotal / count;
        } else {
            return -1;
        }
    }

    public static double doAvgTurnAroundTime() {
        if (count >= 1) {
            return turnaroundTimeTotal / count;
        } else {
            return -1;
        }
    }

    public static double doAvgWaitTime() {
        if (count >= 1) {
            return waitTimeTotal / count;
        } else {
            return -1;
        }
    }





    public static void addProcessingTime(double time){
        processingTimeTotal = processingTimeTotal + time;
        if (time > maxProcessingTime) {
            maxProcessingTime = time;
        }
    }

    public static void addTurnaroundTime(double time){
        turnaroundTimeTotal = turnaroundTimeTotal + time;
        if (time > maxTurnAroundTime) {
            maxTurnAroundTime = time;
        }
    }


    public static void addWaitTime(double time){
        waitTimeTotal = waitTimeTotal + time;
        if (time > maxWaitTime) {
            maxWaitTime = time;
        }
    }

    public static void addEndTime(double time) {
        endTimeTotal = endTimeTotal + time;
        if (time > maxEndTime) {
            maxEndTime = time;
        }
    }

    public static double doThroughPut() {
        double totalProgramRunTime = endProgramTime - startProgramTime;
        return (count / totalProgramRunTime) * 1000.0;

    }

    public static double doCPU_usage() {
        double totalProgramRunTime = endProgramTime - startProgramTime;
        return (processingTimeTotal / totalProgramRunTime) * 100;
    }


    public static void displaySta() {
        System.out.println("average service time: " + doAvgProcessingTime() + " milliseconds");

        System.out.println("max service time: " + maxProcessingTime + " milliseconds");

        System.out.println("average turn around time " + doAvgTurnAroundTime() + " milliseconds");

        System.out.println("max turn around time " + maxTurnAroundTime + " milliseconds");

        System.out.println("average wait time " + doAvgWaitTime() + " milliseconds");

        System.out.println("max wait time " + maxWaitTime + " milliseconds");


        System.out.println("end time " + endProgramTime);
        System.out.println("start time " + startProgramTime);

        System.out.println("processor utilization: " + doCPU_usage() + "%");

        System.out.println("total DAs processed: " + count);

        System.out.println("Throughput: " + doThroughPut());
        System.out.println("---------------------------");


    }

}
