package todoapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";

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
            System.out.println(ANSI_CYAN + "Task added: " + task.getName() + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Task already existed" + ANSI_RESET);
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
            System.out.println(ANSI_CYAN + "Task with ID = " + id + " was eliminated." + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Task with ID = " + id + " doesn't existed." + ANSI_RESET);
        }
    }

    public void editTaskName(int id, String name) {
        int taskIndex = findTaskIndex(id);
        if (taskIndex != -1) {
            tasks.get(taskIndex).setName(name);
        } else {
            System.out.println(ANSI_RED + "Task with ID = " + id + " doesn't existed." + ANSI_RESET);
        }
    }

    public void editTaskStatus(int id, boolean status) {
        int taskIndex = findTaskIndex(id);
        if (taskIndex != -1) {
            tasks.get(taskIndex).setStatus(status);
        } else {
           System.out.println(ANSI_RED + "Task with ID = " + id + " doesn't existed." + ANSI_RESET);
        }
    }

    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            tasks.get(i).getStatusDescription();
            System.out.println(ANSI_PURPLE + (i + 1) + ".Task ID - " + tasks.get(i).getId() + " : " + tasks.get(i).getName());
            System.out.println(ANSI_PURPLE + "+ Status: " + tasks.get(i).getStatusDescription());
            System.out.println(ANSI_PURPLE + "+ Priority: " + tasks.get(i).getPriorityDescription() + ANSI_RESET);
        }
    }

    public void editTaskPriority(int id, int priority) {
        int taskIndex = findTaskIndex(id);
        if (taskIndex != -1) {
            tasks.get(taskIndex).setPriority(priority);
        }
        else {
            System.out.println(ANSI_RED + "Task with ID = " + id + " doesn't existed." + ANSI_RESET);
        }
    }
}
