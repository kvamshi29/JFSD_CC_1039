import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;

public class RamAssistant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ram: Hello! How can I help you?");

        while (true) {
            System.out.print("You: ");
            String command = scanner.nextLine().toLowerCase();

            if (command.contains("hello")) {
                System.out.println("Ram: Hello! How are you?");
            } else if (command.contains("time")) {
                System.out.println("Ram: The current time is " + LocalTime.now());
            } else if (command.contains("date")) {
                System.out.println("Ram: Today's date is " + LocalDate.now());
            } else if (command.contains("exit")) {
                System.out.println("Ram: Goodbye! Have a great day.");
                break;
            } else {
                System.out.println("Ram: Sorry, I didn't understand that.");
            }
        }
        scanner.close();
    }
}
