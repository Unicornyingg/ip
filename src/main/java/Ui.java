import java.util.Scanner;

public class Ui {
    private static final String line = "----------------------------------\n";
    private final Scanner in;

    public Ui() {
        this.in = new Scanner(System.in);
    }

    public String readInput() {
        return in.nextLine().strip();
    }

    public void showWelcome() {
        System.out.println(line + "Hello! I'm John\n"
                + "What can I do for you?\n" + line);
    }

    public void showBye() {
        System.out.println(line + "Bye. Hope to see you again soon!\n" + line);
    }

    public void showError(String message) {
        System.out.println(message);
    }
}
