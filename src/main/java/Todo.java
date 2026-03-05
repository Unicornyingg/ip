/**
 *Represents a todo task.
 */

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    /**
     * Returns the formatted todo string.
     *
     * @return Todo string.
     */
    @Override
    public String toString(){
        return "[T]" + super.toString();

    }

}
