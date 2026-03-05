import java.util.Scanner;

/**
 * Handles user interaction via console input and output.
 */
public class Ui {
    private static final String line = "----------------------------------\n";
    private final Scanner in;

    public Ui() {
        this.in = new Scanner(System.in);
    }

    /**
     * Reads user input.
     *
     * @return Stripped command string.
     */
    public String readInput() {
        return in.nextLine().strip();
    }

    /**
     * Displays the welcome message.
     */
    public void showWelcome() {
        System.out.println(line + "Hello! I'm John\n"
                + "What can I do for you?\n" + line);
    }

    /**
     * Displays the goodbye message.
     */
    public void showBye() {
        System.out.println(line + "Bye. Hope to see you again soon!\n" + line);
    }

    /**
     * Displays an error message.
     *
     * @param message Error message to display.
     */
    public void showError(String message) {
        System.out.println(message);
    }
}
