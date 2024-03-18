import javax.swing.*;

public class Main {
    private static final int noOfThreads = 6;
    private static final int processorLoad = 1000000;

    public static void main(String[] args) {
        Window win = new Window(noOfThreads);
        for (int i = 0; i<noOfThreads; i++)  // Looping to create and start multiple Fir threads
        {
            Fir fir = new Fir(i,i+2,processorLoad);
            fir.addObserver(win); // Adding the Window instance as an observer to the Fir instance
            fir.start();
        }

    }
}

