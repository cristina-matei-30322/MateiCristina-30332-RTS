import java.util.Random;
import java.util.Arrays;

public class SortRandomNumbers {

    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];

        // Generate 10 random numbers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        // Sort the numbers
        Arrays.sort(numbers);

        // Display the sorted numbers
        System.out.println("Sorted numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
