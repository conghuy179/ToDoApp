package todoapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Goi driver
        Scanner sc = new Scanner(System.in);
        ToDoApp app = new ToDoApp();
        Driver driver = new Driver(sc, app);
        driver.run();
        sc.close();
    }
}