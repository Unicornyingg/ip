/**
 * Represents a task with description and completion status.
 */

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a task with the given description.
     *
     * @param description Task description.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon for this task.
     *
     * @return "[X]" if done, "[ ]" otherwise.
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    public void markAsDone(){
        isDone = true;
    }

    public void unmarkDone(){

        isDone = false;
    }

    /**
     * Returns the task description.
     *
     * @return Description text.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Returns the string format used for display and storage.
     *
     * @return Formatted task string.
     */
    @Override
    public String toString(){
        return getStatusIcon() + " " + description;
    }
}

