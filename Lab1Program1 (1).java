class Performance {
    int[] mark = new int[10]; // Array to store marks
    int currentIndex = 0; // Current index to keep track of marks entered

    Performance(String[] marks) {
        this.readMarks(marks); // Constructor to read marks from command line arguments
    }

    void readMarks(String[] marks) {
        // Loop through the provided marks
        for (String mark : marks) {
            int currentMark = Integer.parseInt(mark); // Convert string to integer
            // Check if mark is valid and within the range of 0-100, and the currentIndex is within bounds
            if (currentMark >= 0 && currentMark <= 100 && currentIndex < 10) {
                this.mark[currentIndex++] = currentMark; // Store the mark and increment currentIndex
            } else {
                System.out.println("Invalid Mark: " + currentMark + ". Marks should be between 0-100."); // Display error message for invalid marks
            }
        }
    }

    // Method to find the highest mark
    int highestMark() {
        int high = this.mark[0];
        for (int i = 0; i < currentIndex; i++) {
            if (this.mark[i] > high) {
                high = this.mark[i];
            }
        }
        return high;
    }

    // Method to find the least mark
    int leastMark() {
        int low = this.mark[0];
        for (int i = 0; i < currentIndex; i++) {
            if (this.mark[i] < low) {
                low = this.mark[i];
            }
        }
        return low;
    }

    // Method to get the frequency of the mode mark
    int getFregAtMode() {
        int count = 0;
        int marks = 0;
        for (int i = 0; i < currentIndex; i++) {
            int flag = 0;
            for (int j = 0; j < currentIndex; j++) {
                if (this.mark[i] == this.mark[j]) {
                    flag++;
                }
            }
            if (flag > count) {
                count = flag;
                marks = this.mark[i];
            }
        }
        return count;
    }

    // Method to get the mode mark
    int getMode() {
        int count = 0;
        int marks = this.mark[0];
        int trick = 0;
        for (int i = 0; i < currentIndex; i++) {
            int flag = 0;
            for (int j = 0; j < currentIndex; j++) {
                if (this.mark[i] == this.mark[j]) {
                    flag++;
                }
            }
            if (flag > count) {
                count = flag;
                marks = this.mark[i];
                trick = 1;
            }
            if (flag == count && this.mark[i] != marks) {
                trick = 0;
            }
        }
        if (trick == 1) {
            return marks;
        } else {
            System.out.println("Multi Mode Mark found!");
            return 0;
        }
    }
}

class Lab1Program1 {
    public static void main(String[] args) {
        int a, c;
        // Main program logic
        do {
            Performance obj = new Performance(args); // Create Performance object with marks from command line arguments
            do {
                // Menu for different operations
                System.out.println("Choose an operation\n1. Highest Marks\n2. Least Mark\n3. Mode Mark\n4. Frequency of Mode Mark\n");
                int b = Integer.parseInt(System.console().readLine()); // Read user input for operation choice
                int x = 0;
                // Perform the selected operation
                switch (b) {
                    case 1:
                        x = obj.highestMark();
                        System.out.println("Highest Mark is: " + x);
                        break;
                    case 2:
                        x = obj.leastMark();
                        System.out.println("Least Mark is: " + x);
                        break;
                    case 3:
                        x = obj.getMode();
                        if (x != 0) {
                            System.out.println("Mode Mark is: " + x);
                        }
                        break;
                    case 4:
                        x = obj.getFregAtMode();
                        System.out.println("Frequency of Mode Mark is: " + x);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                System.out.println("Do you wish to continue: 1. Yes. 2. No.");
                a = Integer.parseInt(System.console().readLine()); // Read user input to continue or exit
            } while (a != 2); // Continue the loop as long as the user wants to perform operations
            System.out.println("Do you want to:\n1. Start Again\n2. Exit");
            c = Integer.parseInt(System.console().readLine()); // Read user input to restart or exit the program
        } while (c != 2); // Continue the loop as long as the user wants to restart
        System.out.println("Thank You"); // Display a thank you message when the program exits
    }
}
