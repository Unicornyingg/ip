import java.util.ArrayList;

/**
 * Command that marks a task as not done.
 */
public class UnmarkCommand extends Command {
    private final int userIndex;

    /**
     * Creates an unmark command.
     *
     * @param userIndex Task index.
     */

    public UnmarkCommand(int userIndex) {
        this.userIndex = userIndex;
    }

    /**
     * Unmarks the task and prints confirmation.
     *
     * @param tasks Current task list.
     * @param taskCount Current number of tasks.
     * @return Unchanged task count.
     */
    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) {
        tasks.get(userIndex - 1).unmarkDone();
        System.out.println("OK, I've marked this task as not done yet: \n" + tasks.get(userIndex - 1).toString());
        return taskCount;
    }
}
