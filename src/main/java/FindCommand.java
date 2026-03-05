import java.util.ArrayList;

/**
 * Command that finds tasks by keyword.
 */
public class FindCommand extends Command {
    private static final String line = "----------------------------------\n";
    private final String keyword;

    /**
     * Creates a find command.
     *
     * @param keyword Keyword to search in task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Prints tasks whose descriptions contain the keyword.
     *
     * @param tasks Current task list.
     * @param taskCount Current number of tasks.
     * @return Unchanged task count.
     */
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
