package poe_package_part_2;

import javax.swing.JOptionPane;
import java.util.Scanner;


public class EasyKanban {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to EasyKanban");
            
            System.out.print("Enter the number of tasks you want to add: ");
            int numberOfTasks = scanner.nextInt();
            scanner.nextLine();
            
            Task[] tasks = new Task[numberOfTasks];
            int totalHours = 0;
            for (int i = 0; i < numberOfTasks; i++) {
                System.out.println("\nTask " + (i + 1));
                System.out.print("Task Name: ");
                String taskName = scanner.nextLine();
                System.out.print("Task Description: ");
                String taskDescription = scanner.nextLine();
                while (!checkTaskDescription(taskDescription)) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                    System.out.print("Task Description: ");
                    taskDescription = scanner.nextLine();
                }
                System.out.print("Developer Details: ");
                String developerDetails = scanner.nextLine();
                System.out.print("Task Duration (in hours): ");
                int taskDuration = Integer.parseInt(scanner.nextLine());
                String taskID = createTaskID(taskName, i, developerDetails);
                
                tasks[i] = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskID);
                totalHours += taskDuration;
                
                JOptionPane.showMessageDialog(null, tasks[i].printTaskDetails());
            }
            
            int option;
            do {
                System.out.println("\nPlease choose one of the following options:");
                System.out.println("1) Add tasks");
                System.out.println("2) Show report");
                System.out.println("3) Quit");
                option = scanner.nextInt();
                scanner.nextLine();
                
                switch (option) {
                    case 1 -> {
                        for (int i = 0; i < numberOfTasks; i++) {
                            JOptionPane.showMessageDialog(null, tasks[i].printTaskDetails());
                            String[] options = {"To Do", "Done", "Doing"};
                            int statusOption = JOptionPane.showOptionDialog(null,
                                    "Task Status",
                                    "Select a status",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                            switch (statusOption) {
                                case 0 -> tasks[i].setTaskStatus("To Do");
                                case 1 -> tasks[i].setTaskStatus("Done");
                                case 2 -> tasks[i].setTaskStatus("Doing");
                            }
                        }
                    }
                    case 2 -> JOptionPane.showMessageDialog(null, "Coming Soon");
                    case 3 -> {
                    }
                    default -> JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid option.");
                }
            } while (option != 3);
            
            JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
        }
    }

    public static boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;
    }

    public static String createTaskID(String taskName, int taskNumber, String developerDetails) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }
}
    
