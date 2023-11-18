import java.util.Scanner;

public class LAB2 {
    private static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter the value of K:");
        int k = scanner.nextInt();

        System.out.println("\nOutput:");
        displayLab2(array, k);

        scanner.close();
    }

    public static void displayLab2(int[] array, int k) {
        numbers = array;
        int[] freq = new int[101]; // Assuming the numbers range from 0 to 100

        // Count the frequency of each number
        for (int num : numbers) {
            freq[num]++;
        }

        // Display the top K frequent numbers
        for (int i = 0; i < k; i++) {
            int maxFreq = -1;
            int maxFreqNum = -1;
            boolean kFreqExists = false;

            // Find the number with the maximum frequency
            for (int j = 0; j < freq.length; j++) {
                if (freq[j] > maxFreq) {
                    maxFreq = freq[j];
                    maxFreqNum = j;
                }
            }

            if (maxFreqNum != -1) {
                System.out.print(maxFreqNum + " ");
                freq[maxFreqNum] = -1; // Mark the frequency as visited
                kFreqExists = true;
            }
            if (k > maxFreq) {
                    System.out.println("Invalid k, "+k+" frequency does not exist in the array");
                    break;
                }

            if (!kFreqExists) {
                break;
            }
        }
    }
}
