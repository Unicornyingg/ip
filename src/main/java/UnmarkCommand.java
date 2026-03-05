import java.util.ArrayList;

public class UnmarkCommand extends Command {
    private final int userIndex;

    public UnmarkCommand(int userIndex) {
        this.userIndex = userIndex;
    }

    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) {
        tasks.get(userIndex - 1).unmarkDone();
        System.out.println("OK, I've marked this task as not done yet: \n" + tasks.get(userIndex - 1).toString());
        return taskCount;
    }
}
