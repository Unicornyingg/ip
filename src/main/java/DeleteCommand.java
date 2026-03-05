import java.util.ArrayList;

public class DeleteCommand extends Command {
    private final int userIndex;

    public DeleteCommand(int userIndex) {
        this.userIndex = userIndex;
    }

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
