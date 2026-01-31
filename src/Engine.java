import Core.User;

import java.util.Scanner;

public class Engine {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        User user = login();
    }
    private static User login(){
        nextScreen();
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        nextScreen();
        System.out.print("Welcome, " + userName);
        return null;
    }
    private static void nextScreen(){
        for (int i = 0; i < 30; ++i)
            System.out.println("\n");
    }
}
