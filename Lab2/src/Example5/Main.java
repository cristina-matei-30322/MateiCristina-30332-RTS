package Example5;

public class Main {

    public static void main(String args[]) {
        // Create instances of ReadThread and WriteThread
        ReadThread rt = new ReadThread();
        WriteThread wt = new WriteThread();
        try {
            // Connect the output stream of WriteThread to the input stream of ReadThread
            rt.connect(wt.getPipe());
            // Start both threads
            rt.start();
            wt.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
