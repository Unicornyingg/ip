import java.util.Scanner;



public class John {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = "----------------------------------\n";
        System.out.println(line + "Hello! I'm John\n" +
                        "What can I do for you?\n" + line);
        while(true) {
            String word = in.nextLine();

            if(word.equals("bye")) {
                break;
            }

            System.out.println(line + word + "\n" + line);
        }

        System.out.println(line +
                "Bye. Hope to see you again soon!\n" + line);
    }
}


