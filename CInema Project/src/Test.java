import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Seating cinema = new Seating();
        char numbers = '1';
        int check = 0;

        System.out.println("Enter the number of rows:");
        int rows = input.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = input.nextInt();

        cinema.setRows(rows);
        cinema.setSeats(seats);
        
        Character[][] cinemaSeats = new Character[rows + 1][seats + 1];

        for (Character[] cinemaSeat : cinemaSeats) {
            Arrays.fill(cinemaSeat, 'S');
        }

        cinemaSeats[0][0] = ' ';

        for (int i = 1; i < cinemaSeats[0].length; i++) {
            cinemaSeats[0][i] = numbers;
            numbers++;
        }

        numbers = '1';

        for (int i = 1; i < cinemaSeats.length; i++) {
            cinemaSeats[i][0] = numbers;
            numbers++;
        }
        
        while (check == 0) {

            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int userInput = input.nextInt();

            switch (userInput) {
                case 1 -> cinema.showSeats(cinemaSeats);
                case 2 -> cinema.buyTicket(cinemaSeats);
                case 3 -> cinema.showStatistics();
                case 0 -> check++;
                default -> System.out.println("Please enter 1, 2 or 0.");
            }
        }
    }
}
