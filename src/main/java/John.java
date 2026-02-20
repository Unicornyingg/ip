import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class John {

    private static final String line = "----------------------------------\n";
    private static final String filepath = "src/main/java/tasks.txt";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        try {
           tasks = loadFromFile(filepath);
        }
        catch (FileNotFoundException e) {
            System.out.println("no tasks.txt found.");
        }
        int taskCount = tasks.size();

        System.out.println(line + "Hello! I'm John\n" +
                "What can I do for you?\n" + line);
        while (true) {
            String input = in.nextLine().strip();

            try {
                taskCount = handleCommand(input, taskCount, tasks);
                if (taskCount == -1) {
                    System.out.println(line +
                            "Bye. Hope to see you again soon!\n" + line);
                    break;
                }
            } catch (JohnException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            saveToFile(tasks);
        }
        catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
    }

    public static void saveToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(filepath);
        for (Task task : tasks) {
            fw.write(task.toString() + "\n");
        }
        System.out.println("Tasks saved to file.");
        fw.close();
    }

    private static ArrayList<Task> loadFromFile(String filepath) throws FileNotFoundException{
        File file = new File(filepath);
        ArrayList<Task> tasks = new ArrayList<>();
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine().strip();
                if (line.startsWith("[T]")) {
                    tasks.add(new Todo(line.substring(7)));
                    if (line.charAt(5) == 'X') {
                        tasks.get(tasks.size() - 1).markAsDone();
                    }
                } else if (line.startsWith("[D]")) {
                    tasks.add(new Deadline(line.substring(7, line.indexOf(" (by:")), line.substring(line.indexOf("(by:") + 5, line.indexOf(")"))));
                    if (line.charAt(5) == 'X') {
                        tasks.get(tasks.size() - 1).markAsDone();
                    }
                } else if (line.startsWith("[E]")) {
                    tasks.add(new Events(line.substring(7, line.indexOf(" (from:")), line.substring(line.indexOf("(from:") + 7, line.indexOf(" to:")), line.substring(line.indexOf("to:") + 4, line.indexOf(")"))));
                    if (line.charAt(5) == 'X') {
                        tasks.get(tasks.size() - 1).markAsDone();
                    }
                }
            }
            System.out.println("Loaded tasks from file.");
        }
        else {
            System.out.println("create a file in this path src/main/java/tasks.txt ");
        }

        return tasks;
    }

    private static int handleCommand(String input, int taskCount, ArrayList<Task> tasks) throws JohnException{
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
                if(input.length() < 5){
                    throw new JohnException("mark what? ");
                }
                int item = Integer.parseInt(input.substring(5));
                tasks.get(item - 1).markAsDone();
                System.out.println("Nice! I've marked this task as done: \n" + tasks.get(item - 1).toString());
                return taskCount;

            case "unmark":
                if(input.length() < 7){
                    throw new JohnException("unmark what? ");
                }
                int idx = Integer.parseInt(input.substring(7));
                tasks.get(idx - 1).unmarkDone();
                System.out.println("OK, I've marked this task as not done yet: \n" + tasks.get(idx - 1).toString());
                return taskCount;

            case "todo":
                if(input.length() < 5){
                    throw new JohnException("todo what? ");
                }
                tasks.add(new Todo(input.substring(5)));
                System.out.println("Got it. I've added this task: \n" + tasks.get(taskCount).toString() + "\n" + "Now you have " + (taskCount + 1) + " tasks in the list.");
                taskCount++;
                return taskCount;

            case "deadline":
                if(input.length() < 9){
                    throw new JohnException("what deadline?????? ");
                }

                try {
                    tasks.add(new Deadline(input.substring(9, input.indexOf("/by")), input.substring(input.indexOf("/by") + 4)));
                    System.out.println("Got it. I've added this task: \n" + tasks.get(taskCount).toString() + "\n" + "Now you have " + (taskCount + 1) + " tasks in the list.");
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
                    tasks.add(new Events(input.substring(6, input.indexOf("/from")), input.substring(input.indexOf("/from") + 6, input.indexOf("/to")), input.substring(input.lastIndexOf("/to") + 4)));
                    System.out.println("Got it. I've added this task: \n" + tasks.get(taskCount).toString() + "\n" + "Now you have " + (taskCount + 1) + " tasks in the list.");
                    taskCount++;
                    return taskCount;
                }
                catch (StringIndexOutOfBoundsException e){
                    throw new JohnException("Please type in this format: event <task> /from <date> /to <date>");
                }

            case "delete":
                if(input.length() < 8){
                    throw new JohnException("delete what? ");
                }
                try{
                    tasks.remove(Integer.parseInt(input.substring(7))-1);
                    System.out.println("Deleted task " + (Integer.parseInt(input.substring(7))));
                    taskCount--;
                    return taskCount;
                }
                catch (IndexOutOfBoundsException e){
                    throw new JohnException("Nothing to delete.");
                }

            default:
                throw new JohnException("Invalid command: ");
        }
    }
}



