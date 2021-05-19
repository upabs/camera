package com.oop_lab.view;

import java.util.Map;
import java.util.Scanner;

public class AppView {

    private final Scanner sc = new Scanner(System.in);

    public int menu(String title, String... options) {
        System.out.println("__________ " + title + " __________");
        for (int i = 0; i < options.length; i++)
            System.out.println((i + 1) + ". " + options[i]);

        System.out.print("lua chon: ");
        int result = this.sc.nextInt();
        this.sc.nextLine();

        return result;
    }

    public String getDataInputFilePath() {
        System.out.print("enter the path of data input file: ");
        return this.sc.nextLine();
    }

    public void showResult(Map<String, String> results) {
        System.out.println("__________ Result __________" );
        results.forEach((title, result) -> {
            System.out.println(title + ": " + result);
        });
    }

    public void notice(String title, String message) {
        System.out.println(title + ": " + message);
    }
}
