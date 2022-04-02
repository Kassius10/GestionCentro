package utils;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);

    public static String readString(String message){
        System.out.println(message);
        return sc.nextLine().trim().toLowerCase();
    }
}
