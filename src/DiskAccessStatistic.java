public class DiskAccessStatistic {
    public static double maxWaitTime = 0;
    public static double maxProcessingTime = 0;
    public static long maxTurnAroundTime= 0;


    public static int count;

//    public static double throughPut; // end service time - start consumer time.
//    public static double cpu_usage;

    // Program start / end time
    //public static double mTotalTime;
    public static long startProgramTime;
    public static long endProgramTime;


    // total time
    public static double processingTimeTotal;
    public static double turnaroundTimeTotal;
    public static double waitTimeTotal;





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

    public static void addTurnaroundTime(long time){
        turnaroundTimeTotal = turnaroundTimeTotal + time;
        if (time > maxTurnAroundTime) {
            maxTurnAroundTime = time;
        }
    }


    public static void addWaitTimeTotal(double time){
        waitTimeTotal = waitTimeTotal + time;
        if (time > maxWaitTime) {
            maxWaitTime = time;
        }
    }

    public static double doThroughPut() {


        double totalProgramRunTime = endProgramTime - startProgramTime;
        return (count / totalProgramRunTime) * 1000.0;

    }

    public static double doCPUu_usage() {
        double totalProgramRunTime = endProgramTime - startProgramTime;
        return (processingTimeTotal / totalProgramRunTime) * 1000;
    }


    public static void displaySta() {
//        System.out.println("count: " + count);
//        System.out.println("through_put: " + throughPut);
//        System.out.println("service time total: " + serviceTimeTotal);
//        System.out.println("turnaround time total: " + turnaroundTimeTotal);
//        System.out.println("wait time total: " + waitTimeTotal);
//        System.out.println("max wait time: " + maxWaitTime);
//        System.out.println("max service time: " + maxServiceTime);
//        System.out.println("max turnaround time is: " + maxTurnAroundTime);

//
//        System.out.println("total service time: " + serviceTimeTotal);
//        System.out.println("total turnaround time: " + turnaroundTimeTotal);
//
//        System.out.println("cpu usage: " + cpu_usage);
//        System.out.println("-----------------------------");



        System.out.println("Average Service Time: " + doAvgProcessingTime() + " Milliseconds");

        System.out.println("Max Service Time: " + maxProcessingTime + " Milliseconds");

        System.out.println("Average Turn Around Time " + doAvgTurnAroundTime() + " Milliseconds");

        System.out.println("Max Turn Around Time " + maxTurnAroundTime + " Milliseconds");

        System.out.println("Average Wait Time " + doAvgWaitTime() + " Milliseconds");

        System.out.println("Max Wait Time " + maxWaitTime + " Milliseconds");

        System.out.println("End TIme " + endProgramTime);
        System.out.println("start Time " + startProgramTime);

        System.out.println("Processor Utilization: " + doCPUu_usage() + "%");

        System.out.println("Total DAs processed: " + count);

        System.out.println("Throughput: " + doThroughPut());


    }

}
