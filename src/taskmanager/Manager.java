package taskmanager;
import java.util.ArrayList;

/**
 *
 * @author Lamlsm
 */
public class Manager {

    // List to store all tasks
    private ArrayList<Task> taskList = new ArrayList<>();
    
    // Auto-increment task ID
    private int id = 1;

    /**
     * Add a new task to the list.
     *
     * @param requirementName requirement name
     * @param assignee person assigned to the task
     * @param reviewer person who reviews the task
     * @param taskTypeID task type ID (1-4)
     * @param date task date
     * @param planFrom start time
     * @param planTo end time
     * @return ID of the created task
     * @throws Exception if data is invalid
     */
    public int addTask(String requirementName, String assignee, String reviewer,
            int taskTypeID, String date, double planFrom, double planTo) throws Exception {
        if (taskTypeID < 1 || taskTypeID > 4) {
            throw new Exception("TaskTypeID must be 1-4");
        }
        if (planFrom >= planTo) {
            throw new Exception("Plan From must be < Plan To");
        }
        Task task = new Task(id, taskTypeID, requirementName, date,
                planFrom, planTo, assignee, reviewer);
        taskList.add(task);
        id++;
        return task.getId();
    }

    /**
     * Delete a task by ID.
     *
     * @param id task ID
     * @throws Exception if task is not found
     */
    public void deleteTask(int id) throws Exception {
        for (Task t : taskList) {
            if (t.getId() == id) {
                taskList.remove(t);
                return;
            }
        }
        throw new Exception("Task not found.");
    }

    /**
     * Get the list of tasks.
     *
     * @return show task list
     */
    public ArrayList<Task> showTask() {
        return taskList;
    }
}
