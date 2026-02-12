import java.util.Scanner;

public class John {

    private static final String line = "----------------------------------\n";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Task[] t = new Task[100];
        int taskCount = 0;
        System.out.println(line + "Hello! I'm John\n" +
                "What can I do for you?\n" + line);
        while (true) {
            String input = in.nextLine().strip();

            try {
                taskCount = handleCommand(input, taskCount, t);
                if (taskCount == -1){
                    System.out.println(line +
                            "Bye. Hope to see you again soon!\n" + line);
                    break;
                }
            }
            catch (JohnException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int handleCommand(String input, int taskCount, Task[] t) throws JohnException{
        String cmd = input.split(" ")[0];

        switch (cmd) {
            case "bye":
                return -1;

            case "list":
                System.out.println(line);
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + t[i].toString());
                }
                return taskCount;

            case "mark":
                if(input.length() < 5){
                    throw new JohnException("mark what? ");
                }
                int item = Integer.parseInt(input.substring(5));
                t[item - 1].markAsDone();
                System.out.println("Nice! I've marked this task as done: \n" + t[item - 1].toString());
                return taskCount;

            case "unmark":
                if(input.length() < 7){
                    throw new JohnException("unmark what? ");
                }
                int idx = Integer.parseInt(input.substring(7));
                t[idx - 1].unmarkDone();
                System.out.println("OK, I've marked this task as not done yet: \n" + t[idx - 1].toString());
                return taskCount;

            case "todo":
                if(input.length() < 5){
                    throw new JohnException("todo what? ");
                }
                t[taskCount] = new Todo(input.substring(5));
                System.out.println("Got it. I've added this task: \n" + t[taskCount].toString() + "\n" + "Now you have " + (taskCount + 1) + " tasks in the list.");
                taskCount++;
                return taskCount;

            case "deadline":
                if(input.length() < 9){
                    throw new JohnException("what deadline?????? ");
                }

                try {
                    t[taskCount] = new Deadline(input.substring(9, input.indexOf("/") - 1), input.substring(input.indexOf("/") + 4));
                    System.out.println("Got it. I've added this task: \n" + t[taskCount].toString() + "\n" + "Now you have " + (taskCount + 1) + " tasks in the list.");
                    taskCount++;
                    return taskCount;
                }
                catch (StringIndexOutOfBoundsException e){
                    throw new JohnException("Please type in this format: deadline <task> /by <date>");
                }

            case "event":
                if(input.length() < 6){
                    throw new JohnException("what event?????? ");
                }

                try {
                    t[taskCount] = new Events(input.substring(6, input.indexOf("/from")), input.substring(input.indexOf("/from") + 6, input.indexOf("/to")), input.substring(input.lastIndexOf("/to") + 4));
                    System.out.println("Got it. I've added this task: \n" + t[taskCount].toString() + "\n" + "Now you have " + (taskCount + 1) + " tasks in the list.");
                    taskCount++;
                    return taskCount;
                }
                catch (StringIndexOutOfBoundsException e){
                    throw new JohnException("Please type in this format: event <task> /from <date> /to <date>");
                }

            default:
                throw new JohnException("Invalid command: ");
        }
    }
}



