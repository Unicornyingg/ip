import java.util.ArrayList;

public class MarkCommand extends Command {
    private final int userIndex;

    public MarkCommand(int userIndex) {
        this.userIndex = userIndex;
    }

    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) {
        tasks.get(userIndex - 1).markAsDone();
        System.out.println("Nice! I've marked this task as done: \n" + tasks.get(userIndex - 1).toString());
        return taskCount;
    }
}
