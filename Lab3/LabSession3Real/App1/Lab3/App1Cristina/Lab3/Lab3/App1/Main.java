package LabSession3Real.App1Cristina.Lab3.App1Cristina.Lab3.Lab3.App1;

public class Main {
    public static void main(String[] args) {
        Integer monitor1 = Integer.valueOf(1);
        Integer monitor2 = Integer.valueOf(1);
        new ExecutionThread(monitor1, 2, 4 ).start();
        new ExecutionThread(monitor1, monitor2, 3, 6 ).start();
        new ExecutionThread(monitor2, 2, 5).start();
    }
}
