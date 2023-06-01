package todoapp.models;

import java.util.ArrayList;

public class ToDoApp {
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private ArrayList<ToDoList> toDoLists;

    public ToDoApp() {
        toDoLists = new ArrayList<ToDoList>();
    }

    public void setToDoLists(ArrayList<ToDoList> toDoLists) {
        this.toDoLists = toDoLists;
    }

    public ArrayList<ToDoList> getToDoLists() {
        return toDoLists;
    }

    public ToDoList getToDoList(int index) {
        if (index < toDoLists.size() && index >= 0) {
            return toDoLists.get(index);
        } else {
            return null;
        }
    }

    public void addToDoList(ToDoList toDoList) {
        boolean existed = toDoListExisted(toDoList);
        if (!existed) {
            toDoLists.add(toDoList);
            System.out.println(ANSI_CYAN + "Added To-do list: " + toDoList.getName() + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "To-do list already existed"+ ANSI_RESET);
        }
    }

    public boolean toDoListExisted(ToDoList toDoList) {
        boolean existed = false;
        for (int i = 0; i < toDoLists.size(); i++) {
            if (toDoList.getName().equals(toDoLists.get(i).getName())) {
                existed = true;
                break;
            }
        }
        return existed;
    }

    public void displayToDoLists() {
        for (int i = 0; i < toDoLists.size(); i++) {
            System.out.println(ANSI_PURPLE + "To-do list number " + (i + 1) + ": " + toDoLists.get(i).getName() + ANSI_RESET);
        }
    }
}
