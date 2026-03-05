import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;

public class John {
    private static final String filepath = "tasks.txt";

    public static void main(String[] args) {
        Ui ui = new Ui();
        Storage storage = new Storage();
        Parser parser = new Parser();
        ArrayList<Task> loadedTasks = new ArrayList<>();

        try {
            loadedTasks = storage.loadFromFile(filepath);
        }
        catch (FileNotFoundException e) {
            System.out.println("no tasks.txt found.");
        }
        TaskList taskList = new TaskList(loadedTasks);
        int taskCount = taskList.size();

        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            String input = ui.readInput();

            try {
                Command c = parser.parse(input);
                taskCount = c.execute(taskList.getTasks(), taskCount);
                isExit = c.isExit();
            } catch (JohnException e) {
                ui.showError(e.getMessage());
            }
        }
        ui.showBye();
        try {
            storage.saveToFile(taskList.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
    }
}

