package taskmanager;
import java.util.ArrayList;

/**
 *
 * @author Lamlsm
 */
public class Main {
    public static void main(String[] args) {

        Utility u = new Utility();
        Manager manager = new Manager();

        //Step 1: Show menu
        while (true) {
            System.out.println("========= Task Program =========");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");

            //Step 2: Choice one option 
            int choice = u.getInt("Choice: ", 1, 4);

            switch (choice) {
                
                //Step 3: Add task
                case 1:
                    System.out.println("Add task");
                    try {
                    String name = u.getString("Requirement Name: ");
                    int type = u.getInt("Task Type: ", 1, 4);
                    String date = u.getDate("Date: ");
                    double from = u.getDouble("From: ", 8.0, 17.5);
                    double to = u.getDouble("To: ", 8.0, 17.5);
                    String assignee = u.getString("Assignee: ");
                    String reviewer = u.getString("Reviewer: ");
                    manager.addTask(name, assignee, reviewer, type, date, from, to);
                    System.out.println("Add successfully");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

                //Step 4: Delete task
                case 2:
                    System.out.println("del task");
                    try {
                    int id = u.getInt("ID: ", 1, Integer.MAX_VALUE);
                    manager.deleteTask(id);
                    System.out.println("Delete successfully");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

                //Step 5: Show task
                case 3:
                    System.out.println("task");
                    ArrayList<Task> list = manager.showTask();
                    System.out.printf("%-5s %-15s %-12s %-12s %-6s %-12s %-12s\n",
                            "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
                    for (Task t : list) {
                        double time = t.getPlanTo() - t.getPlanFrom();
                        System.out.printf("%-5d %-15s %-12s %-12s %-6.1f %-12s %-12s\n",
                                t.getId(),
                                t.getRequirementName(),
                                t.getTaskTypeName(),
                                t.getDate(),
                                time,
                                t.getAssignee(),
                                t.getReviewer());
                    }
                    break;

                //Step 6: Exit
                case 4:
                    return;
            }
        }
    }
}