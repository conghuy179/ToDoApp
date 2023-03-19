package todoapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Goi driver
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        ToDoApp app = new ToDoApp();
        Driver driver = new Driver(sc, app);
        driver.run();
        sc.close();
        /*
        // Tao ToDoApp
        ToDoApp toDoApp = new ToDoApp();
        // Tao ToDoList
        ToDoList toDoList = new ToDoList("Work");
        System.out.println("Just created To-do List called: " + toDoList.getName());
        // Add ToDoList vao ToDoApp
        toDoApp.addToDoList(toDoList);
        // Tao Task
        Task task = new Task(1, "Task 1");
        // Add Task vao Todolist
        toDoList.addTask(task);
        // Tao task 2 co dat ten
        Task task2 = new Task(2, "Task 2");
        // Add Task 2 vao Todolist
        toDoList.addTask(task2);
        //Delete 1 task khong ton tai
        toDoList.deleteTask(3);
        // Delete 1 task ton tai
        toDoList.deleteTask(2);
        // Edit ten va status cua task 1
        toDoList.editTaskName(1, "Mua ao moi cho Milu");
        toDoList.editTaskStatus(1, Task.DONE);
        */
    }
}