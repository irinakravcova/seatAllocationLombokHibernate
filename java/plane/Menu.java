package plane;

import lombok.*;

import java.util.Arrays;
import java.util.Scanner;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class Menu {
    Plane plane = new Plane();
    Scanner scanner = new Scanner(System.in);

    public void start() {
        showOptions();
        handleUserChoice();
    }

    private void showOptions() {
        System.out.println("===Seat Allocations System== " +
                "\n Show Available Seat: " +
                "\n 1 - For BUSINESS Type Ticket " +
                "\n 2 - For ECONOMIC Type Ticket " +
                "\n 3 - EXIT ");

    }

    private void handleUserChoice() {
        System.out.println("Select 1, 2 or 3: ");
        String userChoice = scanner.nextLine();

        switch (userChoice) {
            case "1":
                showAvailableBusinessSeats();
                handleBusinessPassengerChoice();
                break;
            case "2":
                showAvailableEconomicSeats();
                handleEconomicPassengerChoice();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Something went wrong. Choose a valid option from the menu");
                break;
        }
       // start();
    }

    private void handleEconomicPassengerChoice() {
        /*this choice method should assign a seat to this passenger and change the status of a seat to UNAVAILABLE
        these UNAVAILABLEBle should not appear in available seats when the next user will try to use the app
        */
    }

    private void handleBusinessPassengerChoice() {
 /*this choice method should assign a seat to this passenger and change the status of a seat to UNAVAILABLE
        these UNAVAILABLEBle should not appear in available seats when the next user will try to use the app
        */
    }

    public void showAvailableBusinessSeats() {
        System.out.println("Type in Your Name here: ");
        String passengerName = scanner.nextLine();
        System.out.println("AVAILABLE BUSINESS seats are:  ");
        /*from DB SELECT * from planeseats where
         TicketType=Business&SeatStatus=AVAILABLE*/
        System.out.println("Choose a seat: ");
        String passengerBusinessChoice = scanner.nextLine();

    }

    private void showAvailableEconomicSeats() {
        System.out.println("Type in Your Name here: ");
        String passengerName = scanner.nextLine();
        System.out.println("AVAILABLE ECONOMIC seats are:  ");
         /*from DB SELECT * from planeseats where
         TicketType=ECONOMIC&SeatStatus=AVAILABLE*/
        System.out.println("Choose a seat: ");
        String passengerEconomicChoice = scanner.nextLine();
    }

 /*   private void handleExit() {
        System.out.println("Enter 1 to exit or 2 to show main menu ");
        if (scanner.nextLine().equals("1")) {
            System.exit(0);
        }
        start();
    }*/

}
