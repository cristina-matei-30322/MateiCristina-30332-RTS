package LabSession3Real.App4;
public class ExecutionThread1 extends Thread {
    int activity_min, activity_max, sleep;
    public ExecutionThread1(int activity_min, int activity_max, int sleep) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
    }
    public synchronized void waitNotify(String name) throws InterruptedException {
        System.out.println(name + " waits");
        wait();
    }
    @Override
    public void run() {
        //state1
        try {
            Thread.sleep(sleep*500);
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
