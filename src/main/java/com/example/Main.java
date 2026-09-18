package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        try (Scanner scanner = new Scanner(System.in)) {
            printOptions();
            while (true) {
                System.out.print("> ");
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+", 2);
                String command = parts[0];

                switch (command) {
                    case "help" -> printOptions();
                    case "add" -> {
                        if (parts.length < 2) {
                            System.out.println("Usage: add <text>");
                        } else {
                            Todo todo = todoList.add(parts[1]);
                            System.out.println("Added: " + todo);
                        }
                    }
                    case "list" -> todoList.list().forEach(System.out::println);
                    case "delete" -> {
                        if (parts.length < 2) {
                            System.out.println("Usage: delete <id>");
                        } else {
                            int id = Integer.parseInt(parts[1]);
                            System.out.println(todoList.delete(id) ? "Deleted " + id : "Not found: " + id);
                        }
                    }
                    case "exit" -> {
                        return;
                    }
                    default -> System.out.println("Unknown command: " + command);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid id: must be a number");
        }
    }

    private static void printOptions() {
        System.out.println("------------------------------");
        System.out.println("Todo CLI");
        System.out.println("Available options:");
        System.out.println("  add <text>    Add a todo");
        System.out.println("  list          Show all todos");
        System.out.println("  delete <id>   Delete a todo");
        System.out.println("  help          Show available options");
        System.out.println("  exit          Exit the application");
        System.out.println("------------------------------");
    }
}
