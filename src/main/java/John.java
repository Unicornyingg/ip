import java.util.Arrays;
import java.util.Scanner;



public class John {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] list = new String[100];
        int taskCount = 0;
        String line = "----------------------------------\n";
        System.out.println(line + "Hello! I'm John\n" +
                        "What can I do for you?\n" + line);
        while(true) {
            String input = in.nextLine();

            if(input.equals("bye")) {
                break;
            }
            else if(input.equals("list")) {
                System.out.println(line);
                for(int i = 0; i < taskCount; i++) {
                    System.out.println((i+1) + ". " + list[i]);
                }
                System.out.println(line);
            }
            else {
                System.out.println(line + "added: " + input + "\n" + line);
                list[taskCount] = input;
                taskCount++;
            }
        }

        System.out.println(line +
                "Bye. Hope to see you again soon!\n" + line);
    }
}


