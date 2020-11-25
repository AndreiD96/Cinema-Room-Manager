
import java.util.Scanner;

public class Seating {

    int rows;
    int seats;
    int cheapTicketCount = 0;
    int highTicketCount = 0;


    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    void showSeats(Character[][] cinemaSeats) {

        System.out.println("Cinema:");
        for (Character[] cinemaSeat : cinemaSeats) {
            for (Character character : cinemaSeat) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }

    void buyTicket(Character[][] cinemaSeats) {

        Scanner input = new Scanner(System.in);
        int a;
        int b;

        do {
            System.out.println("Enter a row number:");
            a = input.nextInt();
            System.out.println("Enter a seat number in that row:");
            b = input.nextInt();
            if (a < 0 || b < 0) {
                System.out.println("Wrong input!");
            }
            if (a > cinemaSeats.length - 1 || b > cinemaSeats[0].length - 1) {
                System.out.println("Wrong input!");
            }
        } while (a < 0 || b < 0 || a > cinemaSeats.length - 1 || b > cinemaSeats[0].length - 1);

        while (cinemaSeats[a][b] == 'B') {
            System.out.println("That ticket has already been purchased");
            System.out.println("Enter a row number:");
            a = input.nextInt();
            System.out.println("Enter a seat number in that row:");
            b = input.nextInt();

        }


        int numberOfSeats = rows * seats;
        int frontSeatingRows = rows / 2;

        if (numberOfSeats <= 60) {

            cinemaSeats[a][b] = 'B';
            System.out.println();
            System.out.println("Ticket price: $10");
            System.out.println();
            System.out.println("Cinema:");

            for (Character[] cinemaSeat : cinemaSeats) {
                for (Character character : cinemaSeat) {
                    System.out.print(character + " ");
                }
                System.out.println();
            }
            highTicketCount++;

        } else if (a <= frontSeatingRows) {

            cinemaSeats[a][b] = 'B';
            System.out.println();
            System.out.println("Ticket price: $10");
            System.out.println();
            System.out.println("Cinema:");

            for (Character[] cinemaSeat : cinemaSeats) {
                for (Character character : cinemaSeat) {
                    System.out.print(character + " ");
                }
                System.out.println();
            }
            highTicketCount++;
        } else {
            cinemaSeats[a][b] = 'B';
            System.out.println();
            System.out.println("Ticket price: $8");
            System.out.println();
            System.out.println("Cinema:");

            for (Character[] cinemaSeat : cinemaSeats) {
                for (Character character : cinemaSeat) {
                    System.out.print(character + " ");
                }
                System.out.println();
            }
            cheapTicketCount++;
        }
    }


    void showStatistics() {

        double ticketsPurchasedTotal = cheapTicketCount + highTicketCount;
        double allPossibleTickets = rows * seats;
        int currentIncome = (cheapTicketCount * 8) + (highTicketCount * 10);
        int numberOfSeats = rows * seats;
        int frontSeatingRows = rows / 2;
        int backSeatsNumber = numberOfSeats - (frontSeatingRows * seats);
        int totalIncome;
        double percentage = (ticketsPurchasedTotal / allPossibleTickets) * 100;

        System.out.println("Number of purchased tickets: " + (int) ticketsPurchasedTotal);

        System.out.printf("Percentage: %.2f%%", percentage);
        System.out.println();

        System.out.println("Current income: $" + currentIncome);

        if (numberOfSeats <= 60) {
            totalIncome = numberOfSeats * 10;
        } else {
            totalIncome = (frontSeatingRows * seats * 10) + (backSeatsNumber * 8);
        }
        System.out.println("Total income: $" + totalIncome);

    }
}
