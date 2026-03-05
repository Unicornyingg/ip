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
        while (true) {
            String input = ui.readInput();

            try {
                taskCount = parser.handleCommand(input, taskCount, taskList.getTasks());
                if (taskCount == -1) {
                    ui.showBye();
                    break;
                }
            } catch (JohnException e) {
                ui.showError(e.getMessage());
            }
        }
        try {
            storage.saveToFile(taskList.getTasks());
        }
        catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
    }
}


