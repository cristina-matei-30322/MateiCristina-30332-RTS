package LabSession3Real.App4;
public class ExecutionThreads2 extends Thread {
    int activity_min, activity_max;
    ExecutionThread1 thread1;
    public ExecutionThreads2(int activity_min, int activity_max, ExecutionThread1 thread1) {
        this.thread1 = thread1;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }
    @Override
    public void run() {
        try {
            thread1.waitNotify(this.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        synchronized (this) {
            this.notify();
        }
        System.out.println(this.getName() + " - STATE 2");
    }
}
