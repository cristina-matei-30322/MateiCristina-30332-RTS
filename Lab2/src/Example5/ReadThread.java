package Example5;

import java.io.PipedOutputStream;
import java.io.*;

class ReadThread extends Thread {

    private PipedInputStream pi;

    // Constructor initializes PipedInputStream
    ReadThread() {
        pi = new PipedInputStream();
    }

    public void run() {
        try {
            while (true) {
                // Check if there are bytes available in the input stream
                if (pi.available() > 0) {
                    // Read and print the received data
                    System.out.println("Read Thread received: " + pi.read());
                }
            }
        } catch (Exception e) {
            // Exception handling
        }
    }

    // Method to connect the PipedOutputStream of WriteThread to this thread's PipedInputStream
    void connect(PipedOutputStream os) throws Exception {
        pi.connect(os);
    }
}