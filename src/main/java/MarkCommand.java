import java.util.ArrayList;

/**
 * Command that marks a task as done.
 */
public class MarkCommand extends Command {
    private final int userIndex;

    /**
     * Creates a mark command.
     *
     * @param userIndex Task index.
     */
    public MarkCommand(int userIndex) {
        this.userIndex = userIndex;
    }

    /**
     * Marks the task and prints confirmation.
     *
     * @param tasks Current task list.
     * @param taskCount Current number of tasks.
     * @return Unchanged task count.
     */
    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) {
        tasks.get(userIndex - 1).markAsDone();
        System.out.println("Nice! I've marked this task as done: \n" + tasks.get(userIndex - 1).toString());
        return taskCount;
    }
}
