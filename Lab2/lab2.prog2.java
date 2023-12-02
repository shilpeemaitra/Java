import java.util.Scanner;

public class ShareTrader {
    private static int maxProfit; // Variable to store the maximum profit

    // Method to find the maximum profit that can be achieved from stock trading
    public static int findMaxProfit(int[] prices) {
        int n = prices.length; // Get the number of stock prices
        if (n < 2) { // Check if there are at least 2 stock prices
            System.out.println("At least 2 stock prices are required to calculate profit.");
            return 0; // Return 0 if there are not enough prices
        }

        int[] profit = new int[n]; // Array to store potential profits
        int maxSell = prices[n - 1]; // Initialize the maximum sell price to the last price

        // Calculate the maximum profit by selling on each day (from right to left)
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > maxSell) { // Update the maximum sell price if a higher price is found
                maxSell = prices[i];
            }
            profit[i] = Math.max(profit[i + 1], maxSell - prices[i]); // Calculate and store potential profit
        }

        int minBuy = prices[0]; // Initialize the minimum buy price to the first price

        // Calculate the maximum profit by buying on each day and considering profits from previous sells
        for (int i = 1; i < n; i++) {
            if (prices[i] < minBuy) { // Update the minimum buy price if a lower price is found
                minBuy = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - minBuy + profit[i]); // Calculate and store the maximum profit
        }

        return maxProfit; // Return the final maximum profit
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of stock prices for the day:");
        int n = scanner.nextInt(); // Read the number of stock prices

        int[] prices = new int[n]; // Array to store stock prices

        System.out.println("Enter the stock prices throughout the day:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt(); // Read the stock prices
        }

        int maxProfit = findMaxProfit(prices); // Calculate the maximum profit
        System.out.println("Maximum Profit: " + maxProfit); // Display the maximum profit

        scanner.close(); // Close the scanner
    }
}
