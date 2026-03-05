import java.util.ArrayList;

public abstract class Command {
    public abstract int execute(ArrayList<Task> tasks, int taskCount) throws JohnException;

    public boolean isExit() {
        return false;
    }
}
