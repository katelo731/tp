package seedu.techtoday;

import seedu.techtoday.apiview.JsonReader;
import static seedu.techtoday.common.Messages.greet;
import seedu.techtoday.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONObject;
import static seedu.techtoday.apiview.JsonReader.newsList;
import seedu.techtoday.apiview.JsonArrayCreator;


public class TechToday {
    public static boolean isRunning = true;
    public static ArrayList<Article> savedArticles = new ArrayList<>();
    public static ArrayList<Article> viewArticles = new ArrayList<>();

    /**
     * Main entry-point for the java.techtoday application.
     */
    public static void main(String[] args) {
        greet();
        Ui ui = new Ui(savedArticles);
        String title1 = "Global oil use heads for steepest annual contraction";
        String url1 = "https://www.worldoil.com/news/2020/3/15/global-oil-use-heads-for-steepest-annual-contraction-in-history";
        Article article1 = new Article(title1, url1, "default");
        String title2 = "Example title";
        String url2 = "www.example.com";
        viewArticles.add(article1);
//      Article article2 = new Article(title2, url2, "default");
//      viewArticles.add(article2, 2);
        Features features = new Features(savedArticles, viewArticles);
        while (isRunning) {
            String userResponse = ui.getCommand();
            String command = userResponse.split(" ")[0];
            String restOfUserInput = userResponse.replace(command, "").trim();

            if (command.equals("view")) {
                try {
                    JsonReader.viewNewNews();
                    //viewArticles = JsonArrayCreator.execute(newsList);
                    //System.out.println(viewArticles.get(1));
                } catch (IOException e) {
                    //We do no need to print anything here because
                    // this exception is already handled at the method level
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

