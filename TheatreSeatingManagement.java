
    import java.util.Scanner;
        public class TheatreSeatingManagement{

        
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private static String[][] seatingChart = new String[ROWS][COLUMNS];

    public static void main(String[] args) {
        initializeSeatingChart();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Display Seating Chart");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    displaySeatingChart();
                    break;
                case 2:
                    bookSeat(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
        scanner.close();
    }

    private static void initializeSeatingChart() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seatingChart[i][j] = "Available";
            }
        }
    }

    private static void displaySeatingChart() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seatingChart[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void bookSeat(Scanner scanner) {
        System.out.print("Enter row (0-4): ");
        int row = scanner.nextInt();
        System.out.print("Enter column (0-4): ");
        int column = scanner.nextInt();

        if (row >= 0 && row < ROWS && column >= 0 && column < COLUMNS) {
            if (seatingChart[row][column].equals("Available")) {
                seatingChart[row][column] = "Booked";
                System.out.println("Seat booked successfully.");
            } else {
                System.out.println("Seat is already booked.");
            }
        } else {
            System.out.println("Invalid seat selection.");
        }
    }

    private static void cancelBooking(Scanner scanner) {
        System.out.print("Enter row (0-4): ");
        int row = scanner.nextInt();
        System.out.print("Enter column (0-4): ");
        int column = scanner.nextInt();

        if (row >= 0 && row < ROWS && column >= 0 && column < COLUMNS) {
            if (seatingChart[row][column].equals("Booked")) {
                seatingChart[row][column] = "Available";
                System.out.println("Booking cancelled successfully.");
            } else {
                System.out.println("No booking found for this seat.");
            }
        } else {
            System.out.println("Invalid seat selection.");
        }
    }
}

