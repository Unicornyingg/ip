import java.util.ArrayList;

/**
 * Represents an executable user command.
 */
public abstract class Command {

    /**
     * Executes this command.
     *
     * @param tasks Current task list.
     * @param taskCount Current number of tasks.
     * @return Updated task count.
     * @throws JohnException If command execution fails.
     */
    public abstract int execute(ArrayList<Task> tasks, int taskCount) throws JohnException;

    /**
     * Returns whether this command should exit the app.
     *
     * @return true if exit command, false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}
