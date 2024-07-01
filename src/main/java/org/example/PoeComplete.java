package org.example;

import javax.swing.JOptionPane;

public class PoeComplete {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to Registration!");
        String Name = JOptionPane.showInputDialog("Enter your name:");
        String Surname = JOptionPane.showInputDialog("Enter your surname:");
        String username = "";
        String password = "";

        // Validate and capture username
        boolean isValidUsername = false;
        while (!isValidUsername) {
            username = JOptionPane.showInputDialog("Enter your username (must contain an underscore and be no longer than 5 characters):");
            isValidUsername = isValidUsername(username);
            if (!isValidUsername) {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters long.");
            }
        }
        // Validate and capture password
        boolean isValidPassword = false;
        while (!isValidPassword) {
            password = JOptionPane.showInputDialog("Enter your password (must be at least 8 characters long, contain a capital letter, a number, and a special character):");
            isValidPassword = isValidPassword(password);
            if (!isValidPassword) {
                JOptionPane.showMessageDialog(null, "Password does not meet the complexity requirements. Please try again.");
            }
        }
        // Display registration success message
        JOptionPane.showMessageDialog(null, "Username and password successfully captured!");

        // Login
        JOptionPane.showMessageDialog(null, "Welcome to Login!");
        String enteredUsername = JOptionPane.showInputDialog("Enter your username:");
        String enteredPassword = JOptionPane.showInputDialog("Enter your password:");

        // Check if username and password match
        if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Login successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Login unsuccessful. Please check your username and password.");
        }
    }
    // Method to validate the username
    private static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }
    // Method to validate the password
    private static boolean isValidPassword(String password) {
        // Password complexity rules
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecialChar;
    }
    public static class Task {
        public Task(String developerDetails) {
        }

        public static class Main {
            private String taskName;
            private int taskNumber;
            private String taskDescription;
            private String developerDetails;
            private int taskDuration;
            private String taskID;
            private String taskStatus;

            public void Task(String taskName, String developerDetails) {
                this.taskName = taskName;
                this.developerDetails = developerDetails;
                this.taskNumber = 0; // Initialize task number to 0
                this.taskStatus = "To Do"; // Initialize task status to "To Do"
            }

            public boolean checkTaskDescription(String description) {
                if (description.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                    return false;
                }
                this.taskDescription = description;
                JOptionPane.showMessageDialog(null, "Task successfully captured");
                return true;
            }

            public String createTaskID() {
                this.taskID = (this.taskName.substring(0, 2) + ":" + this.taskNumber + ":" + this.developerDetails.substring(this.developerDetails.length() - 3)).toUpperCase();
                return this.taskID;
            }

            public String printTaskDetails() {
                return this.taskStatus + ", " + this.developerDetails + ", " + this.taskNumber + ", " + this.taskName + ", " + this.taskDescription + ", " + this.taskID + ", " + this.taskDuration;
            }

            public int returnTotalHours() {
                return this.taskDuration;
            }

            public void setTaskDuration(int duration) {
                this.taskDuration = duration;
            }

            public void setTaskStatus(String status) {
                this.taskStatus = status;
            }

            public void setTaskNumber(int number) {
                this.taskNumber = number;
            }


            public void main(String[] args) {
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
                int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks to add"));
                Task[] tasks = new Task[numTasks];
                int totalHours = 0;

                for (int i = 0; i < numTasks; i++) {
                    String taskName = JOptionPane.showInputDialog("Enter task name");
                    String developerDetails = JOptionPane.showInputDialog("Enter developer details");
                    tasks[i] = new Task(developerDetails);

                    String description = JOptionPane.showInputDialog("Enter task description");
                    while (!tasks[i].checkTaskDescription(description)) {
                        description = JOptionPane.showInputDialog("Enter task description");
                    }

                    int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration"));
                    tasks[i].setTaskDuration(duration);
                    totalHours += duration;

                    tasks[i].setTaskNumber(i);
                    tasks[i].createTaskID();
                    JOptionPane.showMessageDialog(null, tasks[i].printTaskDetails());
                }

                JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
            }
        }

        private void setTaskNumber(int i) {
        }

        private void setTaskDuration(int duration) {
        }

        private Object printTaskDetails() {
            return null;
        }

        private void createTaskID() {

        }

        private boolean checkTaskDescription (String description) {
            return false;
        }
    }
}

// Task class to represent each task
class Task {
    private String developer;
    private String taskName;
    private int duration;
    private boolean done;

    public Task(String developer, String taskName, int duration, boolean done) {
        this.developer = developer;
        this.taskName = taskName;
        this.duration = duration;
        this.done = done;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isDone() {
        return done;
    }
}