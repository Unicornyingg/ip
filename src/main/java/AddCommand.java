import java.util.ArrayList;

public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) {
        tasks.add(task);
        System.out.println("Got it. I've added this task: \n" + tasks.get(taskCount).toString() + "\n"
                + "Now you have " + (taskCount + 1) + " tasks in the list.");
        taskCount++;
        return taskCount;
    }
}
