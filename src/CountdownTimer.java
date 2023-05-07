import java.time.*;

public class CountdownTimer {
    private Duration remainingTime;
    private boolean isRunning;

    public CountdownTimer(Duration duration) {
        remainingTime = duration;
    }

    public void start() {
        if (isRunning) {
            System.out.println("Timer is already running.");
            return;
        }

        isRunning = true;

        while (remainingTime.getSeconds() > 0) {
            clearConsole();
            long minutes = remainingTime.toMinutes();
            long seconds = remainingTime.minusMinutes(minutes).getSeconds();
            System.out.printf("Bus Arrives in: %02d:%02d\r", minutes, seconds);
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            remainingTime = remainingTime.minusSeconds(1);
        }

        clearConsole();
        System.out.println("Bus Has Passed This Stop");
       // System.out.println("Time's up!");
        isRunning = false;
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
