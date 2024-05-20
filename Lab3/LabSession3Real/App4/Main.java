package LabSession3Real.App4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutionThread1 thread1 = new ExecutionThread1(2, 3, 7);
        ExecutionThreads2 thread2 = new ExecutionThreads2(4, 6, thread1);
        ExecutionThreads2 thread3 = new ExecutionThreads2(3, 5, thread1);
        thread1.start();
        thread2.start();
        thread3.start();

        /*thread1.join(); // inside run
        thread2.join();
        thread3.join();*/
    }
}
