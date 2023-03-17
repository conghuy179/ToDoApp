package todoapp;

import java.util.Scanner;

public class Driver {
    private int selection;

    public Driver(int selection) {
        this.selection = selection;
    }

    public void run() {
        System.out.println("This is your To-Do app made by PCH");
        System.out.println("To create a new To-Do List: Press 1.");
        System.out.println("To see your To-Do Lists: Press 2.");
        System.out.println("To close the app: Press 3.");
        Scanner sc = new Scanner(System.in);
        this.selection = sc.nextInt();
        if (selection == 1) {
            // ToDoApp toDoApp = new ToDoApp();
            // toDoApp.addToDoList(new ToDoList("New To-Do List"));
            ToDoList toDoList = new ToDoList();
            System.out.println("Add name for your new To-Do list: ");
            String name = sc.next();
            toDoList.setName(name);
            System.out.println("You just created a new To-Do list named: " +toDoList.getName());
        }
        if (selection == 2) {
            System.out.println("Here are all your To-Do lists: ");
        }
        if (selection == 3) {
            System.out.println("Closed the app.");
        }
    }

    public void addNameToDoList() {

    }
}
