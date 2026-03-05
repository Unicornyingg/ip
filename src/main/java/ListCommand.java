import java.util.ArrayList;

/**
 * Command that lists all tasks.
 */
public class ListCommand extends Command {
    private static final String line = "----------------------------------\n";

    /**
     * Prints all tasks.
     *
     * @param tasks Current task list.
     * @param taskCount Current number of tasks.
     * @return Unchanged task count.
     */
    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) {
        System.out.println(line);
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
        return taskCount;
    }
}
