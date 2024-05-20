package LabSession3Real.App3;

import java.sql.SQLOutput;

public class ExecutionThread extends Thread{
     Integer monitor;
     int activity_min, activity_max, sleep;
     public ExecutionThread(Integer monitor, int activity_min, int activity_max, int sleep) {
         this.monitor = monitor;
         this.activity_min = activity_min;
         this.activity_max = activity_max;
         this.sleep = sleep;
     }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                //state 1
                System.out.println(this.getName() + " - STATE 1");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                System.out.println(this.getName() + " released monitor");
            }
            System.out.println(this.getName() + " - STATE 2");
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 3");
        }
    }
}
