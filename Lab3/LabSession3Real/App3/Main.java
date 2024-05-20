package LabSession3Real.App3;

public class Main {
    public static void main(String[] args) {
        Integer monitor = Integer.valueOf(1);
        new ExecutionThread(monitor, 3,6,5).start();
        new ExecutionThread(monitor, 4,7,3).start();
        new ExecutionThread(monitor, 5,7,6).start();
    }

}
