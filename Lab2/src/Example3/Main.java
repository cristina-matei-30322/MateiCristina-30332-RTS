package Example3;

public class Main {
    static int sum = 0; // Static variable to store sum

    public static void main(String[] args) {
        // Create threads
        JoinTestThread w1 = new JoinTestThread("Thread 1", 50000, null);
        JoinTestThread w2 = new JoinTestThread("Thread 2", 20000, w1);

        // Start threads
        w1.start();
        w2.start();

        try {
            // Wait for threads to finish
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the sum
        System.out.println(Main.sum);
    }
}