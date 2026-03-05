# John Task Manager

John is a Java command-line task manager for tracking todos, deadlines, and events.

## Quick Start

1. Compile:
   `javac -d out src/main/java/*.java`
2. Run:
   `java -cp out John`

## Main Commands

- `todo DESCRIPTION`
- `deadline DESCRIPTION /by DUE DATE/TIME`
- `event DESCRIPTION /from START DATE/TIME /to END DATE/TIME`
- `list`
- `mark INDEX`
- `unmark INDEX`
- `delete INDEX`
- `find KEYWORD`
- `bye`

## Date/Time Behavior

- Parseable values are formatted when displayed:
  - Date: `MMM dd yyyy`
  - Date-time: `MMM dd yyyy h:mma`
- Non-parseable values (for example `monday`) are kept as entered.

## User Guide

Full usage details are in [docs/README.md](docs/README.md).
