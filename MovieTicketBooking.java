import java.util.*;

public class MovieTicketBooking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Available movies:");
        System.out.println("1. Avengers: Endgame");
        System.out.println("2. Black Widow");
        System.out.println("3. Spider-Man: No Way Home");
        System.out.print("Enter the movie number you want to watch: ");
        int movieChoice = scanner.nextInt();

        System.out.println("Available dates:");
        System.out.println("1. May 1, 2023");
        System.out.println("2. May 2, 2023");
        System.out.println("3. May 3, 2023");
        System.out.print("Enter the date you want to watch the movie: ");
        int dateChoice = scanner.nextInt();

        System.out.println("Available times:");
        System.out.println("1. 10:00 AM");
        System.out.println("2. 2:00 PM");
        System.out.println("3. 6:00 PM");
        System.out.print("Enter the time you want to watch the movie: ");
        int timeChoice = scanner.nextInt();

        int[][] seatMatrix = generateSeatMatrix();

        System.out.println("Seat matrix:");
        for (int[] row : seatMatrix) {
            for (int seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }

        System.out.print("Enter the number of tickets you want to book: ");
        int numTickets = scanner.nextInt();

        int numSeats = countSeats(seatMatrix);
        if (numTickets > numSeats) {
            System.out.println("Sorry, there are not enough seats available.");
        } else {
            for (int i = 1; i <= numTickets; i++) {
                System.out.printf("Select seat %d (row column): ", i);
                int seatRow = scanner.nextInt();
                int seatCol = scanner.nextInt();
                if (seatMatrix[seatRow][seatCol] == 1) {
                    System.out.println("Sorry, that seat is already booked.");
                    i--;
                } else {
                    seatMatrix[seatRow][seatCol] = 1;
                }
            }
            System.out.println("Congratulations, your tickets have been booked!");
        }
    }

    public static int[][] generateSeatMatrix() {
        Random random = new Random();
        int[][] seatMatrix = new int[23][22];
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 22; j++) {
                seatMatrix[i][j] = random.nextInt(2);
            }
        }
        return seatMatrix;
    }

    public static int countSeats(int[][] seatMatrix) {
        int count = 0;
        for (int[] row : seatMatrix) {
            for (int seat : row) {
                if (seat == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}