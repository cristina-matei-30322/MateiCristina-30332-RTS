package Example5;

import java.io.PipedOutputStream;
import java.io.*;

class WriteThread extends Thread {

    private PipedOutputStream po;

    // Constructor initializes PipedOutputStream
    WriteThread() {
        po = new PipedOutputStream();
    }

    public void run() {
        try {
            while (true) {
                // Generate random data and write it to the output stream
                int d = (int) (10 * Math.random());
                System.out.println("Writing Thread sent: " + d);
                po.write(d);
                // Sleep for a while
                sleep(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get the PipedOutputStream for connecting to ReadThread
    PipedOutputStream getPipe() {
        return po;
    }
}
