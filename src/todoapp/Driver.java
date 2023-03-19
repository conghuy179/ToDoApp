package todoapp;

import java.util.Scanner;


public class Driver {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static final int CHOICE_TODOLIST_CREATE = 1;
    private static final int CHOICE_TODOLIST_VIEW = 2;
    private static final int CHOICE_TASK_ADD = 3;
    private static final int CHOICE_TASK_EDIT = 4;
    private static final int CHOICE_CLOSE_APP = 0;
    private static final int CHOICE_TASK_EDIT_NAME = 1;
    private static final int CHOICE_TASK_EDIT_STATUS = 2;
    private static final int CHOICE_TASK_DELETE = 3;
    private static final int CHOICE_TASK_RETURN = 0;


    // nhap input
    private Scanner sc;
    private ToDoApp app;
    private int selection;
    private int secondSelection;

    public Driver(Scanner sc, ToDoApp app) {
        this.sc = sc;
        this.app = app;
    }

    public void printInstructions() {
        System.out.println(ANSI_BLUE + "------------------------------------------");
        System.out.println("----This is your To-Do app made by PCH----");
        System.out.println("------------------------------------------");
        System.out.printf("To create a new To-Do List:        Press %d.\n", CHOICE_TODOLIST_CREATE);
        System.out.printf("To see your To-Do Lists and Tasks: Press %d.\n", CHOICE_TODOLIST_VIEW);
        System.out.printf("To add tasks:                      Press %d.\n", CHOICE_TASK_ADD);
        System.out.printf("To edit tasks:                     Press %d.\n", CHOICE_TASK_EDIT);
        System.out.printf("To close the app:                  Press %d.\n", CHOICE_CLOSE_APP);
        System.out.println("------------------------------------------" + ANSI_RESET);
        System.out.print("Please enter your choice: ");
    }

    public void printEditInstruction() {
        System.out.println(ANSI_BLUE + "------------------------------------------");
        System.out.printf("To edit task's name:             Press %d.\n", CHOICE_TASK_EDIT_NAME);
        System.out.printf("To edit task's status:           Press %d.\n", CHOICE_TASK_EDIT_STATUS);
        System.out.printf("To delete task:                  Press %d.\n", CHOICE_TASK_DELETE);
        System.out.printf("To return:                       Press %d.\n", CHOICE_TASK_RETURN);
        System.out.println("------------------------------------------" + ANSI_RESET);
    }

    public void run() {
        do {
            printInstructions();

            this.selection = sc.nextInt();

            if (selection == CHOICE_TODOLIST_CREATE) {
                generateNewToDoList();
            } else if (selection == CHOICE_TODOLIST_VIEW) {
                System.out.println(ANSI_WHITE + "Here are all your To-Do lists: " + ANSI_RESET);
                app.displayToDoLists();
                System.out.println(ANSI_CYAN + "Select which To-Do list to see tasks: " + ANSI_RESET);
                int selectTdl = sc.nextInt();
                ToDoList selectedTdl = app.getToDoList(selectTdl - 1);
                if (selectedTdl == null) {
                    System.out.println(ANSI_RED + "To-do list not found." + ANSI_RESET);
                    continue;
                }
                selectedTdl.displayTasks();
            } else if (selection == CHOICE_TASK_ADD) {
                System.out.println(ANSI_WHITE + "Here is the list of your To-Do lists: " + ANSI_RESET);
                app.displayToDoLists();
                System.out.print(ANSI_CYAN + "Select the desired To-Do list: " + ANSI_RESET);
                int selectTdl = sc.nextInt();
                ToDoList selectedTdl = app.getToDoList(selectTdl - 1);
                if (selectedTdl == null) {
                    System.out.println(ANSI_RED + "To-do list not found." + ANSI_RESET);
                    continue;
                }
                System.out.print(ANSI_CYAN + "Write task's name: ");
                String name = sc.next();
                System.out.print("Write task's ID: " + ANSI_RESET);
                int id = sc.nextInt();
                Task newTask = new Task(id, name);
                selectedTdl.addTask(newTask);
                selectedTdl.displayTasks();
            } else if (selection == CHOICE_TASK_EDIT) {
                System.out.println(ANSI_WHITE + "Here is the list of your To-Do lists: " + ANSI_RESET);
                app.displayToDoLists();
                System.out.print(ANSI_CYAN + "Select the desired To-Do list: " + ANSI_RESET);
                int selectTdl = sc.nextInt();
                ToDoList selectedTdl = app.getToDoList(selectTdl - 1);
                if (selectedTdl == null) {
                    System.out.println(ANSI_RED + "To-do list not found." + ANSI_RESET);
                    break;
                } else {
                    selectedTdl.displayTasks();
                    System.out.println(ANSI_WHITE + "Type ID's number of the task you want to edit: " + ANSI_RESET);
                    int idTask = sc.nextInt();
                    Task newTask = new Task(idTask);
                    String name = newTask.getName();
                    System.out.println("Please enter your choice: ");
                    do {
                        printEditInstruction();
                        this.secondSelection = sc.nextInt();

                        if (secondSelection == CHOICE_TASK_EDIT_NAME) {
                            selectedTdl.editTaskName(idTask, name);
                        } else if (secondSelection == CHOICE_TASK_EDIT_STATUS) {
                            boolean status = newTask.getStatus();
                            selectedTdl.editTaskStatus(idTask, status);
                        } else if (secondSelection == CHOICE_TASK_DELETE) {
                            selectedTdl.deleteTask(idTask);
                            break;
                        } else if (secondSelection == CHOICE_TASK_RETURN) {
                            System.out.println("Return to main screen.");
                        } else {
                            System.out.println(ANSI_RED + "Unknown selection. Please run again." + ANSI_RESET);
                        }
                    } while (secondSelection != CHOICE_TASK_RETURN);
                }

            } else if (selection == CHOICE_CLOSE_APP) {
                System.out.println("Closed the app.");
            } else {
                System.out.println(ANSI_RED + "Unknown selection. Please run again." + ANSI_RESET);
            }
        }
        while (selection != CHOICE_CLOSE_APP);
    }

    public void generateNewToDoList() {
        // Tao todolist
        ToDoList toDoList = new ToDoList();
        System.out.println(ANSI_CYAN + "Add name for your new To-Do list: " + ANSI_RESET);
        //Gan tdlname vao ten todolist
        String name = sc.next();
        toDoList.setName(name);
        app.addToDoList(toDoList);
        System.out.println(ANSI_PURPLE + "You just created a new To-Do list named: " + toDoList.getName() + ANSI_RESET);
    }
}
