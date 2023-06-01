package todoapp.models;

public class Task {
    public static final int LOW_PRIORITY = 1;
    public static final int MEDIUM_PRIORITY = 2;
    public static final int HIGH_PRIORITY = 3;
    public static final boolean DONE = true;
    public static final boolean DOING = false;
    private int id;
    private String name;
    private int priority;
    private boolean status;
    // private String duedate;


    public Task(int id) {
        setStatus(DOING);
        setPriority(LOW_PRIORITY);
        setId(id);
    }

    public Task(int id, String name) {
        setStatus(DOING);
        setPriority(LOW_PRIORITY);
        setId(id);
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getPriorityDescription() {
        if (priority == 1) {
            return "Low priority";
        }
        if (priority == 2) {
            return "Medium priority";
        }
        if (priority == 3) {
            return "High priority";
        }
        return "Unknown priority";
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public String getStatusDescription() {
        if (status == DOING) {
            return "DOING";
        }
        if (status == DONE) {
            return "DONE";
        }
        return "Unknown status";
    }
}
