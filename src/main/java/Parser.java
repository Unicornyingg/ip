import java.util.ArrayList;

public class Parser {
    private static final String line = "----------------------------------\n";

    public int handleCommand(String input, int taskCount, ArrayList<Task> tasks) throws JohnException {
        String cmd = input.split(" ")[0];

        switch (cmd) {
        case "bye":
            return -1;

        case "list":
            System.out.println(line);
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).toString());
            }
            return taskCount;

        case "mark":
            if (input.length() < 5) {
                throw new JohnException("mark what? ");
            }
            int item = Integer.parseInt(input.substring(5));
            tasks.get(item - 1).markAsDone();
            System.out.println("Nice! I've marked this task as done: \n" + tasks.get(item - 1).toString());
            return taskCount;

        case "unmark":
            if (input.length() < 7) {
                throw new JohnException("unmark what? ");
            }
            int idx = Integer.parseInt(input.substring(7));
            tasks.get(idx - 1).unmarkDone();
            System.out.println("OK, I've marked this task as not done yet: \n" + tasks.get(idx - 1).toString());
            return taskCount;

        case "todo":
            if (input.length() < 5) {
                throw new JohnException("todo what? ");
            }
            tasks.add(new Todo(input.substring(5)));
            System.out.println("Got it. I've added this task: \n" + tasks.get(taskCount).toString() + "\n"
                    + "Now you have " + (taskCount + 1) + " tasks in the list.");
            taskCount++;
            return taskCount;

        case "deadline":
            if (input.length() < 9) {
                throw new JohnException("what deadline?????? ");
            }

            try {
                tasks.add(new Deadline(input.substring(9, input.indexOf("/by")), input.substring(input.indexOf("/by")
                        + 4)));
                System.out.println("Got it. I've added this task: \n" + tasks.get(taskCount).toString() + "\n"
                        + "Now you have " + (taskCount + 1) + " tasks in the list.");
                taskCount++;
                return taskCount;
            } catch (StringIndexOutOfBoundsException e) {
                throw new JohnException("Please type in this format: deadline <task> /by <date>");
            }

        case "event":
            if (input.length() < 6) {
                throw new JohnException("what event?????? ");
            }

            try {
                tasks.add(new Events(input.substring(6, input.indexOf("/from")),
                        input.substring(input.indexOf("/from") + 6, input.indexOf("/to")),
                        input.substring(input.lastIndexOf("/to") + 4)));
                System.out.println("Got it. I've added this task: \n" + tasks.get(taskCount).toString() + "\n"
                        + "Now you have " + (taskCount + 1) + " tasks in the list.");
                taskCount++;
                return taskCount;
            } catch (StringIndexOutOfBoundsException e) {
                throw new JohnException("Please type in this format: event <task> /from <date> /to <date>");
            }

        case "delete":
            if (input.length() < 8) {
                throw new JohnException("delete what? ");
            }
            try {
                tasks.remove(Integer.parseInt(input.substring(7)) - 1);
                System.out.println("Deleted task " + (Integer.parseInt(input.substring(7))));
                taskCount--;
                return taskCount;
            } catch (IndexOutOfBoundsException e) {
                throw new JohnException("Nothing to delete.");
            }

        default:
            throw new JohnException("Invalid command: ");
        }
    }
}
