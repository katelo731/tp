package seedu.techtoday.apiview;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import seedu.techtoday.Article;



/** Represents a creates a list of news that can be viewed by the user. */
public class JsonArrayCreator {

    /**
     * Takes a JSON object and converts it into an ArrayList containing article objects.
     *
     * @throws IOException   IO exception.
     * @throws JSONException JSON exception.
     */


    public static ArrayList<Article> execute(JSONObject newsList) {
        ArrayList<Article> articlesViewed = new ArrayList<>();
        Iterator<String> keys = JsonReader.newsList.keys();
        JSONObject json = new JSONObject(newsList);
        while (keys.hasNext()) {
            String key = keys.next();
            String object = json.getString(key);
            System.out.println(object);
           // String title = object.getString("title");
            //String url = object.getString("url");
            //System.out.println(title);
//            JSONObject detailsOfKey = new JSONObject(newsList.get(key));
//            System.out.println(detailsOfKey.toString());
//            String title = detailsOfKey.getString("title");
//            System.out.println(title);
//            String url = detailsOfKey.getString("url");
            //Article article = new Article(title, url, "default");
            //articlesViewed.add(article);
        }
        return articlesViewed;
    }
}


