class Lab1Program1 {
    public static void main(String[] args) {
        int a, c;
        int[] marks = new int[args.length];
        int currentIndex = 0;

        // Store marks from command line arguments
        for (String arg : args) {
            int currentMark = Integer.parseInt(arg);
            if (currentMark >= 0 && currentMark <= 100 && currentIndex < 10) {
                marks[currentIndex++] = currentMark;
            } else {
                System.out.println("Invalid Mark: " + currentMark + ". Marks should be between 0-100.");
            }
        }

        // Main program logic
        do {
            do {
                // Menu for different operations
                System.out.println("Choose an operation\n1. Highest Marks\n2. Least Mark\n3. Mode Mark\n4. Frequency of Mode Mark\n");
                int b = Integer.parseInt(System.console().readLine()); // Read user input for operation choice
                int x = 0;

                // Perform the selected operation
                switch (b) {
                    case 1:
                        int high = marks[0];
                        for (int i = 0; i < currentIndex; i++) {
                            if (marks[i] > high) {
                                high = marks[i];
                            }
                        }
                        System.out.println("Highest Mark is: " + high);
                        break;
                    case 2:
                        int low = marks[0];
                        for (int i = 0; i < currentIndex; i++) {
                            if (marks[i] < low) {
                                low = marks[i];
                            }
                        }
                        System.out.println("Least Mark is: " + low);
                        break;
                    case 3:
                        // Mode Mark
                        int count = 0;
                        int mode = marks[0];
                        int trick = 0;
                        for (int i = 0; i < currentIndex; i++) {
                            int flag = 0;
                            for (int j = 0; j < currentIndex; j++) {
                                if (marks[i] == marks[j]) {
                                    flag++;
                                }
                            }
                            if (flag > count) {
                                count = flag;
                                mode = marks[i];
                                trick = 1;
                            }
                            if (flag == count && marks[i] != mode) {
                                trick = 0;
                            }
                        }
                        if (trick == 1) {
                            System.out.println("Mode Mark is: " + mode);
                        } else {
                            System.out.println("Multi Mode Mark found!");
                        }
                        break;
                    case 4:
                        // Frequency of Mode Mark
                        int freqCount = 0;
                        int freqMarks = 0;
                        for (int i = 0; i < currentIndex; i++) {
                            int flag = 0;
                            for (int j = 0; j < currentIndex; j++) {
                                if (marks[i] == marks[j]) {
                                    flag++;
                                }
                            }
                            if (flag > freqCount) {
                                freqCount = flag;
                                freqMarks = marks[i];
                            }
                        }
                        System.out.println("Frequency of Mode Mark is: " + freqCount);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                System.out.println("Do you wish to continue: 1. Yes. 2. No.");
                a = Integer.parseInt(System.console().readLine());
            } while (a != 2);
            System.out.println("Do you want to:\n1. Start Again\n2. Exit");
            c = Integer.parseInt(System.console().readLine());
        } while (c != 2);
        System.out.println("Thank You");
    }
}
