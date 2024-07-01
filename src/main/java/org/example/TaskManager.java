package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class TaskManager {
    public static void main(String[] args) {
        // ArrayList to store tasks
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            // Menu options
            String[] options = {"Add Task", "Display Tasks (Done)", "Longest Duration Task",
                    "Search Task", "Delete Task", "Display Report", "Exit"};

            // Show menu and get user's choice
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Task Manager",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Add Task
                    addTask(tasks);
                    break;
                case 1: // Display Tasks (Done)
                    displayDoneTasks(tasks);
                    break;
                case 2: // Longest Duration Task
                    displayLongestDurationTask(tasks);
                    break;
                case 3: // Search Task
                    searchTask(tasks);
                    break;
                case 4: // Delete Task
                    deleteTask(tasks);
                    break;
                case 5: // Display Report
                    displayReport(tasks);
                    break;
                case 6: // Exit
                    JOptionPane.showMessageDialog(null, "Exiting Task Manager. Goodbye!", "Exit", JOptionPane.INFORMATION_MESSAGE);
                    return;
                default:
                    break;
            }
        }
    }

    // Method to add a new task
    private static void addTask(ArrayList<Task> tasks) {
        String developer = JOptionPane.showInputDialog("Enter developer name:");
        String taskName = JOptionPane.showInputDialog("Enter task name:");
        int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in days:"));
        boolean done = JOptionPane.showConfirmDialog(null, "Is the task done?", "Task Status",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        Task newTask = new Task(developer, taskName, duration, done);
        tasks.add(newTask);

        JOptionPane.showMessageDialog(null, "Task added successfully!", "Task Added", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to display tasks marked as done
    private static void displayDoneTasks(ArrayList<Task> tasks) {
        StringBuilder message = new StringBuilder();
        message.append("Tasks marked as 'done':\n");

        for (Task task : tasks) {
            if (task.isDone()) {
                message.append("Developer: ").append(task.getDeveloper()).append("\n");
                message.append("Task Name: ").append(task.getTaskName()).append("\n");
                message.append("Task Duration: ").append(task.getDuration()).append(" days\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, message.toString(), "Tasks Done", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to display the task with the longest duration
    private static void displayLongestDurationTask(ArrayList<Task> tasks) {
        int longestDuration = 0;
        Task longestTask = null;

        for (Task task : tasks) {
            if (task.getDuration() > longestDuration) {
                longestDuration = task.getDuration();
                longestTask = task;
            }
        }

        if (longestTask != null) {
            StringBuilder message = new StringBuilder();
            message.append("Developer of the task with longest duration:\n");
            message.append("Developer: ").append(longestTask.getDeveloper()).append("\n");
            message.append("Task Duration: ").append(longestTask.getDuration()).append(" days\n");

            JOptionPane.showMessageDialog(null, message.toString(), "Longest Duration Task", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found.", "Longest Duration Task", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method to search for a task by name, developer, and status
    private static void searchTask(ArrayList<Task> tasks) {
        String searchTerm = JOptionPane.showInputDialog("Enter task name or developer name:");
        boolean found = false;

        StringBuilder message = new StringBuilder();
        message.append("Search Results:\n");

        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(searchTerm) ||
                    task.getDeveloper().equalsIgnoreCase(searchTerm)) {
                message.append("Task Name: ").append(task.getTaskName()).append("\n");
                message.append("Developer: ").append(task.getDeveloper()).append("\n");
                message.append("Task Status: ").append(task.isDone() ? "Done" : "Not Done").append("\n\n");
                found = true;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, message.toString(), "Search Results", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No matching tasks found.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method to delete a task by name
    private static void deleteTask(ArrayList<Task> tasks) {
        String taskNameToDelete = JOptionPane.showInputDialog("Enter task name to delete:");
        boolean found = false;

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTaskName().equalsIgnoreCase(taskNameToDelete)) {
                tasks.remove(i);
                JOptionPane.showMessageDialog(null, "Task deleted successfully.", "Delete Task", JOptionPane.INFORMATION_MESSAGE);
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Task not found.", "Delete Task", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method to display a report of all tasks
    private static void displayReport(ArrayList<Task> tasks) {
        StringBuilder report = new StringBuilder();
        report.append("Task Report:\n");

        for (Task task : tasks) {
            report.append("Developer: ").append(task.getDeveloper()).append("\n");
            report.append("Task Name: ").append(task.getTaskName()).append("\n");
            report.append("Task Duration: ").append(task.getDuration()).append(" days\n");
            report.append("Task Status: ").append(task.isDone() ? "Done" : "Not Done").append("\n\n");
        }

        if (tasks.isEmpty()) {
            report.append("No tasks found.\n");
        }

        JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.INFORMATION_MESSAGE);
    }
}
