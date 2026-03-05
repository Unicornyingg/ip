import java.util.ArrayList;

public class FindCommand extends Command {
    private static final String line = "----------------------------------\n";
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public int execute(ArrayList<Task> tasks, int taskCount) {
        System.out.println(line);
        System.out.println("Here are the matching tasks in your list:");

        int matchedCount = 0;
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                matchedCount++;
                System.out.println(matchedCount + ". " + task.toString());
            }
        }

        return taskCount;
    }
}
