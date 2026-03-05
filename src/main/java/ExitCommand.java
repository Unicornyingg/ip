import java.util.ArrayList;

public class ExitCommand extends Command {
    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) {
        return -1;
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
