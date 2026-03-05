import java.util.ArrayList;

public class Parser {
    public int handleCommand(String input, int taskCount, ArrayList<Task> tasks) throws JohnException {
        Command c = parse(input);
        return c.execute(tasks, taskCount);
    }

    public Command parse(String input) throws JohnException {
        String cmd = input.split(" ")[0];

        switch (cmd) {
        case "bye":
            return new ExitCommand();

        case "list":
            return new ListCommand();

        case "mark":
            if (input.length() < 5) {
                throw new JohnException("mark what? ");
            }
            int item = Integer.parseInt(input.substring(5));
            return new MarkCommand(item);

        case "unmark":
            if (input.length() < 7) {
                throw new JohnException("unmark what? ");
            }
            int idx = Integer.parseInt(input.substring(7));
            return new UnmarkCommand(idx);

        case "todo":
            if (input.length() < 5) {
                throw new JohnException("todo what? ");
            }
            return new AddCommand(new Todo(input.substring(5)));

        case "deadline":
            if (input.length() < 9) {
                throw new JohnException("what deadline?????? ");
            }

            try {
                return new AddCommand(new Deadline(input.substring(9, input.indexOf("/by")),
                        input.substring(input.indexOf("/by") + 4)));
            } catch (StringIndexOutOfBoundsException e) {
                throw new JohnException("Please type in this format: deadline <task> /by <date>");
            }

        case "event":
            if (input.length() < 6) {
                throw new JohnException("what event?????? ");
            }

            try {
                return new AddCommand(new Events(input.substring(6, input.indexOf("/from")),
                        input.substring(input.indexOf("/from") + 6, input.indexOf("/to")),
                        input.substring(input.lastIndexOf("/to") + 4)));
            } catch (StringIndexOutOfBoundsException e) {
                throw new JohnException("Please type in this format: event <task> /from <date> /to <date>");
            }

        case "delete":
            if (input.length() < 8) {
                throw new JohnException("delete what? ");
            }
            return new DeleteCommand(Integer.parseInt(input.substring(7)));

        case "find":
            if (input.length() < 5 || input.substring(5).isBlank()) {
                throw new JohnException("find what? ");
            }
            return new FindCommand(input.substring(5).strip());

        default:
            throw new JohnException("Invalid command: ");
        }
    }
}
