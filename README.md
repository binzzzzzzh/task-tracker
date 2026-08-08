# Task Tracker CLI

A command-line interface (CLI) Task Tracker application built with **Java** and **Spring Boot**. Data is safely persisted locally in a JSON file. 

This is a practice project designed to hone Object-Oriented Programming (OOP) skills, File I/O operations, and practical CLI application development.

## Features

- **Add** a new task.
- **Update** an existing task's description.
- **Delete** a task.
- **Update status:** Mark a task as `in-progress` or `done`.
- **List tasks:** View all tasks or filter them by status (`todo`, `in-progress`, `done`).
- **Clear All:** Delete all tasks from the list with a single command.
- **Auto-save:** All data is automatically saved to a local `tasks.json` file.

## Tech Stack

- **Language:** Java 17+
- **Framework:** Spring Boot (CommandLineRunner)
- **Build Tool:** Maven
- **Storage:** JSON (File I/O)

## Installation & Setup

Open your terminal at the root directory of the project and run the following command to compile and package the source code:

`.\mvnw clean package -DskipTests`

If you can't compile the source code, Press **Window + R**, type **%temp%** then delete all the files in there, if a warning pop up, click **remember my choice** then **skip**. Use the command above to recompile.

## Usage
Use the `.\task-cli` command followed by your desired action:

### 1. Add new task:

`.\task-cli add "Your description"`

### 2. List tasks:

- `.\task-cli list`
- `.\task-cli list done`
- `.\task-cli list todo`
- `.\task-cli list in-progress`

### 3. Update a task description:

`.\task-cli update 1 "Your new description"`

### 4. Mark lists status:

- `.\task-cli mark-in-progress 1`
- `.\task-cli mark-done 1`

### 5. Delete task:

- `.\task-cli delete 1`
- `.\task-cli delete all` to delete all tasks.

#### Project inspired by the [Roadmap.sh - Task Tracker](https://roadmap.sh/projects/task-tracker) backend learning path.
