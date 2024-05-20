package Example3;

import java.util.Random;

// Custom Thread class
class JoinTestThread extends Thread {
    // Instance variables
    Thread t; // Reference to another thread for joining
    String n; // Name of the thread
    int num; // Number used for computation

    // Constructor
    JoinTestThread(String n, int num, Thread t) {
        this.setName(n); // Set the name of the thread
        this.n = n; // Initialize name
        this.t = t; // Initialize reference to another thread
        this.num = num; // Initialize number used for computation
    }

    // Method to get the number used for computation
    public int getNum() {
        return this.num;
    }

    // Method to calculate the number of divisors for a given number
    public int getNumDiv(int num) {
        Random random = new Random();

        // Generate a random number greater than the given number
        int randomNumber = random.nextInt(Integer.MAX_VALUE - num) + num + 1;
        System.out.println("random number: " + randomNumber);
        int div = 2;
        int numDiv = 2;
        int copy = randomNumber;

        while (div <= randomNumber / 2) {
            if (randomNumber % div == 0) {
                numDiv++;
                Main.sum+=div;
                System.out.println(div + " for " + randomNumber);
            }

            while (copy % div == 0)
                copy /= div;

            div++;
        }
        return numDiv;
    }

    // Run method of the thread
    public void run() {
        System.out.println("Thread " + n + " has entered the run() method");

        try {
            // If there's another thread to join, wait for it to finish
            if (t != null)
                t.join();

            // Perform computation
            System.out.println("Thread " + n + " executing operation.");
            int numDiv = getNumDiv(getNum());
            Main.sum += numDiv; // Add computed value to sum
            System.out.println("Thread " + n + " has terminated operation.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}