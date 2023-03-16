package todoapp;
import java.util.ArrayList;

public class ToDoApp {
    private ArrayList<ToDoList> toDoLists;

    public ToDoApp() {
        toDoLists = new ArrayList<ToDoList>();
    }
    public void addToDoList(ToDoList toDoList) {
        boolean existed = toDoListExisted(toDoList);
        if (!existed) {
            toDoLists.add(toDoList);
            System.out.println("Added To-do list: " + toDoList.getName());
        }
        else {
            System.out.println("To-do list already existed");
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
}
