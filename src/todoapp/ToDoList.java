package todoapp;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> tasks;
    private String name;
    public ToDoList() {
        this.tasks = new ArrayList<Task>();
    }

    public ToDoList(String name) {
        this.tasks = new ArrayList<Task>();
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        boolean existed = taskExisted(task);
        if (!existed) {
            tasks.add(task);
            System.out.println("Task added: " + task.getName());
        } else {
            System.out.println("Task already existed");
        }
    }

    public boolean taskExisted(Task task) {
        boolean existed = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getId() == tasks.get(i).getId()) {
                existed = true;
                break;
            }
        }
        return existed;
    }

    public int findTaskIndex(int id) {
        int taskIndex = -1;
        for (int i = 0; i < tasks.size(); i++) {
            if (id == tasks.get(i).getId()) {
                taskIndex = i;
                break;
            }
        }
        return taskIndex;
    }

    public void deleteTask(int id) {
        int taskIndex = findTaskIndex(id);

        if (taskIndex != -1) {
            tasks.remove(taskIndex);
            System.out.println("Task with ID = " + id + " was eliminated.");
        } else {
            System.out.println("Task with ID = " + id + " doesn't existed.");
        }
    }

    public void editTaskName(int id, String name) {
        int taskIndex = findTaskIndex(id);
        if (taskIndex != -1) {
            tasks.get(taskIndex).setName(name);
            System.out.println("Task's name is changed to: " + tasks.get(taskIndex).getName());
        } else {
            System.out.println("Task with ID = " + id + " doesn't existed.");
        }
    }

    public void editTaskStatus(int id, boolean status) {
        int taskIndex = findTaskIndex(id);
        if (taskIndex != -1) {
            tasks.get(taskIndex).setStatus(status);
            System.out.println("Task's status is changed to: " + tasks.get(taskIndex).getStatus());
        } else {
            System.out.println("Task with ID = " + id + " doesn't existed.");
        }
    }
}
