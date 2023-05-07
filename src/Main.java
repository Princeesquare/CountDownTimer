import java.time.*;

public class Main {
    public static void main(String[] args) {
        // Generate a random target time within the range of 20 to 25 minutes
        //int start = 10; //+ (int) (Math.random() * 6);
        Duration start = Duration.ofMinutes(10);

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