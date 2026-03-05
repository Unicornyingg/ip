import java.util.ArrayList;

public class ListCommand extends Command {
    private static final String line = "----------------------------------\n";

    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) {
        System.out.println(line);
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
        return taskCount;
    }
}
