import java.util.ArrayList;

/**
 * Command that exits the application.
 */
public class ExitCommand extends Command {
    /**
     * Executes exit behavior.
     *
     * @param tasks Current task list.
     * @param taskCount Current number of tasks.
     * @return -1 to indicate exit.
     */
    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) {
        return -1;
    }

    /**
     * Indicates that this command exits the loop.
     *
     * @return true.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
