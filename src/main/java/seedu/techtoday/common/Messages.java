package seedu.techtoday.common;

import org.jetbrains.annotations.NotNull;

public class Messages {
    public static String HEADER_LINE = "     ﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎";
    public static String BOTTOM_LINE = "     ﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊";
    public static String SPLIT_LINE = "______________________________________________________________";

    /** Let the statement be printed in center. **/
    public static void printInCenter(@NotNull String str) {
        int left = (83 - str.length()) / 2;
        int right = 83 - left - str.length();
        String repeatedChar = " ";
        String buff = "\t∣"
                + repeatedChar.repeat(Math.max(0, left))
                + str
                + repeatedChar.repeat(Math.max(0, right - 1))
                + "∣";
        System.out.println(buff);
    }

    /** Show a ASCII code message to user. **/
    public static void greet() {
        System.out.println(HEADER_LINE);
        printInCenter("_____  ____  __    _    _____  ___   ___    __    _    ");
        printInCenter(" | |  | |_  / /`  | |_|  | |  / / \\ | | \\  / /\\  \\ \\_/ ");
        printInCenter(" |_|  |_|__ \\_\\_, |_| |  |_|  \\_\\_/ |_|_/ /_/--\\  |_|  ");
        printInCenter("");
        printInCenter("Hello! Here's TechToday.");
        printInCenter("Let me show you some technology news to refresh your mind!");
        printInCenter(SPLIT_LINE);
        printInCenter("Your queries can be of the following forms:");
        printInCenter("1. view [topic]");
        printInCenter("2. list [category (optional)]");
        printInCenter("3. save [article number] [category (optional)]");
        printInCenter("4. add [category]");
        printInCenter("5. delete [category] [article number (optional)]");
        printInCenter("");
        System.out.println(BOTTOM_LINE);
        System.out.println("     What can I do for you?");
        System.out.println();
    }
}
