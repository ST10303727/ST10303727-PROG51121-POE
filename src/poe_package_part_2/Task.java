package poe_package_part_2;

public class Task {
    private String taskID;
    private String taskDescription;
    private int hours;

    public Task(String taskDescription, int hours) {
        this.taskID = createTaskID();
        this.taskDescription = taskDescription;
        this.hours = hours;
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        return UUID.randomUUID().toString();
    }

    public String printTaskDetails() {
        return "Task ID: " + taskID + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Hours: " + hours;
    }

    public int returnTotalHours() {
        return hours;
    }
}
class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskID) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = taskID;
        this.taskStatus = "To Do";
    }
