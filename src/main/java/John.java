import java.util.Arrays;
import java.util.Scanner;

public class John {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Task[] t = new Task[100];
        int taskCount = 0;
        String line = "----------------------------------\n";
        System.out.println(line + "Hello! I'm John\n" +
                        "What can I do for you?\n" + line);
        while(true) {
            String input = in.nextLine().strip();

            if(input.equals("bye")) {
                break;
            }
            else if(input.equals("list")) {
                System.out.println(line);
                for(int i = 0; i < taskCount; i++) {
                    System.out.println((i+1) + ". " + t[i].toString());
                }
                System.out.println(line);
            }
            else if(input.startsWith("mark")) {
                int item = Integer.parseInt(input.substring(5));
                t[item-1].markAsDone();
                System.out.println("Nice! I've marked this task as done: \n" + t[item-1].toString());
            }
            else if(input.startsWith("unmark")) {
                int item = Integer.parseInt(input.substring(7));
                t[item-1].unmarkDone();
                System.out.println("OK, I've marked this task as not done yet: \n" + t[item-1].toString());
            }
            else if(input.startsWith("todo")) {
                t[taskCount] = new Todo(input.substring(5));
                System.out.println("Got it. I've added this task: \n" + t[taskCount].toString() + "\n" + "Now you have " + (taskCount + 1) + " tasks in the list.");
                taskCount++;

            }
            else if( input.startsWith("deadline")){
                t[taskCount] = new Deadline(input.substring(9, input.indexOf("/")-1), input.substring(input.indexOf("/") + 4));
                System.out.println("Got it. I've added this task: \n" + t[taskCount].toString() + "\n" + "Now you have " + (taskCount + 1) + " tasks in the list.");
                taskCount++;
            }
            else if(input.startsWith("event")){
                t[taskCount] = new Events(input.substring(6, input.indexOf("/from")), input.substring(input.indexOf("/from") + 6, input.indexOf("/to")), input.substring(input.lastIndexOf("/to") + 4));
                System.out.println("Got it. I've added this task: \n" + t[taskCount].toString() + "\n" + "Now you have " + (taskCount + 1) + " tasks in the list.");
                taskCount++;
            }
        }

        System.out.println(line +
                "Bye. Hope to see you again soon!\n" + line);
    }
}


