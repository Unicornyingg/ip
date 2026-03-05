# John User Guide

John is a command-line task manager. It helps you track todos, deadlines, and events from your terminal.

## Quick Start

1. Ensure you are using JDK 17.
2. Compile the project:
   `javac -d out src/main/java/*.java`
3. Run the app:
   `java -cp out John`
4. Enter commands shown in the features below.

John saves tasks to `tasks.txt` in the project root.

## Features

### Add todo

Adds a todo task.

Format: `todo DESCRIPTION`

Example:
`todo read book`

### Add deadline

Adds a deadline task.

Format: `deadline DESCRIPTION /by DUE DATE/TIME`

`DUE DATE/TIME` can be:
- Date only: `yyyy-MM-dd`
- Date and time: `yyyy-MM-dd HHmm` or `yyyy-MM-dd HH:mm`
- Any other text (for example: `monday`)

If `DUE DATE/TIME` is parseable as date/time, John prints it as:
- Date: `MMM dd yyyy` (for example: `Mar 05 2026`)
- Date-time: `MMM dd yyyy h:mma` (for example: `Mar 05 2026 6:00PM`)

Example:
`deadline return book /by 2026-03-05 1800`

### Add event

Adds an event task.

Format: `event DESCRIPTION /from START DATE/TIME /to END DATE/TIME`

`START DATE/TIME` and `END DATE/TIME` support the same date/time behavior as deadlines:
- Parseable values are reformatted to `MMM dd yyyy` or `MMM dd yyyy h:mma`
- Non-parseable values are kept as entered

Example:
`event lecture /from 2026-03-06 0900 /to 2026-03-06 1100`

### List tasks

Shows all tasks with numbering.

Format: `list`

### Mark task as done

Marks a task as done.

Format: `mark INDEX`

Example:
`mark 2`

### Unmark task

Marks a task as not done.

Format: `unmark INDEX`

Example:
`unmark 2`

### Delete task

Deletes a task.

Format: `delete INDEX`

Example:
`delete 3`

### Find tasks

Finds tasks whose descriptions contain a keyword.

Format: `find KEYWORD`

Example:
`find book`

### Exit

Exits John and saves tasks to file.

Format: `bye`

## Notes

- Commands are case-sensitive.
- Invalid command formats will show an error message.
- Task data is loaded from `tasks.txt` on startup and saved on exit.
