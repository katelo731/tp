package seedu.techtoday;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for User Interface objects and interacting with user commands.
 */
public class Ui {

    public static ArrayList<Article> savedArticles;

    public Ui(ArrayList<Article> articles) {
        this.savedArticles = articles;
    }

    /**
     * Returns the trimmed command of the user input.
     * @return String representation of user input trimmed.
     */
    public String getCommand() {
        Scanner userInput = new Scanner(System.in);
        String userResponse = userInput.nextLine();
        return userResponse.trim();
    }
}
