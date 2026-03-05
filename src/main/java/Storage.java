import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static final String filepath = "tasks.txt";

    public void saveToFile(ArrayList<Task> tasks) throws IOException {
        Path path = Paths.get(filepath);

        Path directory = path.getParent();
        if (directory != null && !Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        if (Files.notExists(path)) {
            Files.createFile(path);
        }

        FileWriter fw = new FileWriter(path.toFile());

        for (Task task : tasks) {
            fw.write(task.toString() + "\n");
        }
        System.out.println("Tasks saved to file.");
        fw.close();
    }

    public ArrayList<Task> loadFromFile(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        Path path = Paths.get(filepath);
        Path directory = path.getParent();
        ArrayList<Task> tasks = new ArrayList<>();

        if (directory != null && !Files.exists(directory)) {
            try {
                Files.createDirectories(directory);
            } catch (IOException e) {
                System.out.println("Error creating the directory.");
                return tasks;
            }
        }

        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
                System.out.println("File created: " + filepath);
            } catch (IOException e) {
                System.out.println("Error creating the file.");
                return tasks;
            }
        }
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String line = sc.nextLine().strip();
            if (line.startsWith("[T]")) {
                tasks.add(new Todo(line.substring(7)));
                if (line.charAt(5) == 'X') {
                    tasks.get(tasks.size() - 1).markAsDone();
                }
            } else if (line.startsWith("[D]")) {
                tasks.add(new Deadline(line.substring(7, line.indexOf(" (by:")),
                        line.substring(line.indexOf("(by:") + 5, line.indexOf(")"))));
                if (line.charAt(5) == 'X') {
                    tasks.get(tasks.size() - 1).markAsDone();
                }
            } else if (line.startsWith("[E]")) {
                tasks.add(new Events(line.substring(7, line.indexOf(" (from:")),
                        line.substring(line.indexOf("(from:") + 7, line.indexOf(" to:")),
                        line.substring(line.indexOf("to:") + 4, line.indexOf(")"))));
                if (line.charAt(5) == 'X') {
                    tasks.get(tasks.size() - 1).markAsDone();
                }
            }
        }
        System.out.println("Loaded tasks from file.");

        return tasks;
    }
}
