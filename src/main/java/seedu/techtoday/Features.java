package seedu.techtoday;

import java.util.Scanner;
import java.util.ArrayList;

import static seedu.techtoday.common.Messages.HEADER_LINE;
import static seedu.techtoday.common.Messages.BOTTOM_LINE;
import static seedu.techtoday.common.Messages.printInCenter;

public class Features {

    public static ArrayList<Article> savedArticles;
    public static ArrayList<Article> viewArticles;
    
    /**
    * Add an article found outside the program.
    */
    public void addArticle() {
        System.out.println(HEADER_LINE);
        printInCenter("Enter the name of the article: ");
        Scanner in = new Scanner(System.in);
        String articleName = in.nextLine();
        printInCenter("Enter the url of the article: ");
        String articleUrl = in.nextLine();
        Article toAdd = new Article(articleName, articleUrl, "default");
        savedArticles.add(toAdd);
        printInCenter("You saved a new article: " + toAdd);
        System.out.println(BOTTOM_LINE);
    }


    /**
     * Saves a chose article from view to the saved articles list.
     * @param command - The command given by the user.
     */
    public void saveView(String command) {
        int articleNum = Integer.parseInt(command) - 1;
        Article toSave = viewArticles.get(articleNum);
        savedArticles.add(toSave);
        System.out.println(HEADER_LINE);
        printInCenter("This article has been saved: " + toSave);
        System.out.println(BOTTOM_LINE);
    }


    /**
     * Lists all saved articles by category.
     * @param category - The command given by the user.
     */
    public void list(String category) {
        System.out.println(HEADER_LINE);
        for (Article savedArticle : savedArticles) {
            if (!category.isEmpty()) {
                printInCenter(savedArticle.toString());
            } else if (Article.category.equals(category)) {
                printInCenter(savedArticle.toString());
            }
        }
        System.out.println(BOTTOM_LINE);
    }

    /**
     * Removes an article/articles from the list.
     * @param category - The given category to find articles.
     * @param articleID - Article ID in a category.
     */
    public void remove(String category, Integer articleID) {
        if (articleID == null) {
            System.out.println(HEADER_LINE);
            printInCenter("You are going to remove all articles in this category!");
            System.out.println(BOTTOM_LINE);
            savedArticles.removeIf(savedArticle -> Article.category.equals(category));
        } else {
            savedArticles.remove(articleID);
        }
    }
}
