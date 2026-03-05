import java.util.ArrayList;

/**
 * Command that deletes a task by index.
 */
public class DeleteCommand extends Command {
    private final int userIndex;

    /**
     * Creates a delete command.
     *
     * @param userIndex Task index.
     */
    public DeleteCommand(int userIndex) {
        this.userIndex = userIndex;
    }

    /**
     * Deletes the task and prints confirmation.
     *
     * @param tasks Current task list.
     * @param taskCount Current number of tasks.
     * @return Updated task count.
     * @throws JohnException If task index is invalid.
     */
    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) throws JohnException {
        try {
            tasks.remove(userIndex - 1);
            System.out.println("Deleted task " + userIndex);
            taskCount--;
            return taskCount;
        } catch (IndexOutOfBoundsException e) {
            throw new JohnException("Nothing to delete.");
        }
    }
}
