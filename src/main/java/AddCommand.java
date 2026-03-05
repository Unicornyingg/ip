import java.util.ArrayList;

/**
 * Command that adds a task.
 */
public class AddCommand extends Command {
    private final Task task;

    /**
     * Creates an add command.
     *
     * @param task Task to add.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Adds the task and prints confirmation.
     *
     * @param tasks Current task list.
     * @param taskCount Current number of tasks.
     * @return Updated task count.
     */
    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) {
        tasks.add(task);
        System.out.println("Got it. I've added this task: \n" + tasks.get(taskCount).toString() + "\n"
                + "Now you have " + (taskCount + 1) + " tasks in the list.");
        taskCount++;
        return taskCount;
    }
}
