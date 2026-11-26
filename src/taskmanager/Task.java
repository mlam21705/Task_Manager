package taskmanager;

/**
 *
 * @author Lamlsm
 */
public class Task {

    // Task ID
    private int id;
    //private String name;
    private int taskTypeID;
    private String requirementName;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task(int id, int taskTypeID, String requirementName,
            String date, double planFrom, double planTo,
            String assignee, String reviewer) {

        this.id = id;
        this.requirementName = requirementName;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

//    public String getName() {
//        return name;
//    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public String getDate() {
        return date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    /**
     * Get task type name based on taskTypeID.
     *
     * @return task type name
     */
    public String getTaskTypeName() {
        return switch (taskTypeID) {
            case 1 ->
                "Code";
            case 2 ->
                "Test";
            case 3 ->
                "Design";
            case 4 ->
                "Review";
            default ->
                "";
        };
    }
}
