package seedu.techtoday;

import seedu.techtoday.apiview.JsonReader;
import static seedu.techtoday.common.Messages.greet;
import seedu.techtoday.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TechToday {
    public static boolean isRunning = true;
    public static ArrayList<Article> savedArticles = new ArrayList<>();
    public static ArrayList<Article> viewArticles;

    /**
     * Main entry-point for the java.techtoday application.
     */
    public static void main(String[] args) {
        greet();
        Ui ui = new Ui(savedArticles);
        Features features = new Features(savedArticles, viewArticles);
        while (isRunning) {
            String userResponse = ui.getCommand();
            String command = userResponse.split(" ")[0];
            String restOfUserInput = userResponse.replace(command, "").trim();

            if (command.equals("view")) {
                try {
                    JsonReader.viewNewNews();
                } catch (IOException e) {
                    System.out.println("Error with view command!");
                }
            } else if (command.equals("save")) {
                features.saveView(restOfUserInput);
            } else if (command.equals("list")) {
                features.list();
            } else if (command.equals("add")) {
                features.addArticle();
            } else if (command.equals("delete")) {
                features.delete(restOfUserInput);
            } else if (command.equals("create")) {
                // do create command
            } else if (command.equals("exit")) {
                isRunning = false;
            } else {
                System.out.println("Invalid command! Please try again!");
            }
        }
    }
}

