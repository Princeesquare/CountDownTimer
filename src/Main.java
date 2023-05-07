import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Taking the start time from a user
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the start Time: ");
        int startTime = input.nextInt();

        // Don't forget to close the scanner when you're done with it
        input.close();

        Duration start = Duration.ofMinutes(startTime);

        // Get the current time
        LocalTime currentTime = LocalTime.now();

        // Calculate the remaining time
        Duration duration = Duration.between(currentTime, currentTime.plus(start));

        if (duration.getSeconds() <= 0) {
            System.out.println("Target time must be in the future. Exiting...");
            return;
        }

        // Create and start the countdown timer
        CountdownTimer timer = new CountdownTimer(duration);
        timer.start();
    }
}